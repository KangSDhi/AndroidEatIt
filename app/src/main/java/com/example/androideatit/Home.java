package com.example.androideatit;

import android.content.Intent;
import android.os.Bundle;

import com.example.androideatit.Common.Common;
import com.example.androideatit.Decoration.ItemLinearDecoration;
import com.example.androideatit.Interface.ItemClickListener;
import com.example.androideatit.Model.ModelKategori;
import com.example.androideatit.Model.ModelPengguna;
import com.example.androideatit.ViewHolder.MenuViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.TextView;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView TextNamaUser;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Kategori");
    FirebaseRecyclerAdapter<ModelKategori, MenuViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final FloatingActionButton fab_Search = findViewById(R.id.fab_search);
        final FloatingActionButton fab_Close = findViewById(R.id.fab_close);
        fab_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab_Close.show();
                fab_Search.hide();
            }
        });
        fab_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fab_Close.hide();
                fab_Search.show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_round_menu_24px);

        View headerView = navigationView.getHeaderView(0);
        TextNamaUser = headerView.findViewById(R.id.textNameUser);
        TextNamaUser.setText(Common.currentModelPengguna.getNama_Depan()+" "+Common.currentModelPengguna.getNama_Belakang());

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view_kategori);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        memuatKategori();

        navigationView.setNavigationItemSelectedListener(this);
    }

    private void memuatKategori() {
       adapter = new FirebaseRecyclerAdapter<ModelKategori, MenuViewHolder>(
               ModelKategori.class,
               R.layout.menu_item,
               MenuViewHolder.class,
               databaseReference
       ) {
           @Override
           protected void populateViewHolder(MenuViewHolder menuViewHolder, ModelKategori modelKategori, final int i) {
               Picasso.get().load(modelKategori.getGambar()).into(menuViewHolder.imageView);
               menuViewHolder.txtNama.setText(modelKategori.getNama());
               menuViewHolder.setItemClickListener(new ItemClickListener() {
                   @Override
                   public void onClick(View view, int position, boolean isLongClick) {
                       Intent intent = new Intent(Home.this, FoodList.class);
                       intent.putExtra("keyKategori", adapter.getRef(position).getKey());
                       startActivity(intent);
                   }
               });
           }
       };
       recyclerView.setAdapter(adapter);

       int smallPadding = 16;
       int largePadding = 16;
       recyclerView.addItemDecoration(new ItemLinearDecoration(smallPadding, largePadding));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_carts) {
            startActivity(new Intent(Home.this, Cart.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menu) {
            // Handle the camera action
        } else if (id == R.id.nav_cart) {
            startActivity(new Intent(Home.this, Cart.class));
        } else if (id == R.id.nav_orders) {
            startActivity(new Intent(Home.this, OrderStatus.class));
        } else if (id == R.id.nav_logout) {
            Intent signIn = new Intent(Home.this, SignIn.class);
            signIn.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(signIn);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
