package com.example.androideatit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.androideatit.Database.Database;
import com.example.androideatit.Model.ModelMakanan;
import com.example.androideatit.Model.ModelOrder;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shawnlin.numberpicker.NumberPicker;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.Locale;

public class FoodDetail extends AppCompatActivity {

    TextView food_name, food_price, food_description, text_porsi;
    ImageView food_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    com.shawnlin.numberpicker.NumberPicker numberPicker;

    String KeyFood = "";

    FirebaseDatabase database;
    DatabaseReference databaseReference;

    ModelMakanan modelMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        //Firebase
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Makanan");

        //init view
        food_name = (TextView)findViewById(R.id.food_name);
        food_price = (TextView)findViewById(R.id.food_price);
        food_description = (TextView)findViewById(R.id.food_description);
        text_porsi = (TextView)findViewById(R.id.text_porsi);
        food_image = (ImageView)findViewById(R.id.img_food);

        Typeface customHeader = Typeface.createFromAsset(getAssets(), "fonts/ConcertOne-Regular.ttf");
        food_name.setTypeface(customHeader);
        food_price.setTypeface(customHeader);
        text_porsi.setTypeface(customHeader);
        food_description.setTypeface(customHeader);

        //numberButton = (ElegantNumberButton)findViewById(R.id.number_button);
        numberPicker = (NumberPicker) findViewById(R.id.number_picker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(20);

        btnCart = (FloatingActionButton)findViewById(R.id.btnCart);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int PickerValue = numberPicker.getValue();
                new Database(getBaseContext()).addToCart(new ModelOrder(
                        KeyFood,
                        modelMakanan.getNama(),
                        Integer.toString(PickerValue),
                        modelMakanan.getHarga(),
                        modelMakanan.getDiskon()
                ));
                Toast.makeText(FoodDetail.this, "Added to cart", Toast.LENGTH_SHORT).show();
            }
        });

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collpasing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

        if (getIntent() != null)
        {
            KeyFood = getIntent().getStringExtra("keyFood");
            if (KeyFood != null)
            {
                getDetailFood(KeyFood);
            }
        }
    }

    private void getDetailFood(String keyFood) {
        databaseReference.child(keyFood).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                modelMakanan = dataSnapshot.getValue(ModelMakanan.class);
                Picasso.get().load(modelMakanan.getGambar()).into(food_image);
                collapsingToolbarLayout.setTitle(modelMakanan.getNama());
                food_name.setText(modelMakanan.getNama());
                food_price.setText(NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(Integer.parseInt(modelMakanan.getHarga())));
                food_description.setText(modelMakanan.getDeskripsi());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
