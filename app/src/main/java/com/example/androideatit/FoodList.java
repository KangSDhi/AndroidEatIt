package com.example.androideatit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androideatit.Decoration.ItemLinearDecoration;
import com.example.androideatit.Interface.ItemClickListener;
import com.example.androideatit.Model.ModelMakanan;
import com.example.androideatit.ViewHolder.FoodViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class FoodList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Makanan");
    FirebaseRecyclerAdapter<ModelMakanan, FoodViewHolder> adapter;

    String KeyKategori = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view_food_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if (getIntent() != null)
        {
            KeyKategori = getIntent().getStringExtra("keyKategori");
            if (KeyKategori != null)
            {
                memuatListMakanan(KeyKategori);
            }
        }
    }

    private void memuatListMakanan(String keyKategori) {
        adapter = new FirebaseRecyclerAdapter<ModelMakanan, FoodViewHolder>(
                ModelMakanan.class,
                R.layout.food_item,
                FoodViewHolder.class,
                databaseReference.orderByChild("MenuId").equalTo(keyKategori)
        ) {
            @Override
            protected void populateViewHolder(FoodViewHolder foodViewHolder, final ModelMakanan modelMakanan, int i) {
                Picasso.get().load(modelMakanan.getGambar()).into(foodViewHolder.ImageViewMakanan);
                foodViewHolder.TextMakanan.setText(modelMakanan.getNama());

                foodViewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                       Intent intent = new Intent(FoodList.this, FoodDetail.class);
                       intent.putExtra("keyFood", adapter.getRef(position).getKey());
                       startActivity(intent);
                    }
                });
            }
        };
        recyclerView.setAdapter(adapter);
        int allPadding = 16;
        recyclerView.addItemDecoration(new ItemLinearDecoration(allPadding, allPadding));
    }
}
