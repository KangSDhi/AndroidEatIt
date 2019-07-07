package com.example.androideatit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androideatit.Common.Common;
import com.example.androideatit.Model.ModelRequest;
import com.example.androideatit.ViewHolder.OrderViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OrderStatus extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<ModelRequest, OrderViewHolder> adapter;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Permintaan");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_status);

        recyclerView = (RecyclerView)findViewById(R.id.listOrders);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadOrders(Common.currentModelPengguna.getTelepon());
    }

    private void loadOrders(String telepon) {
        adapter = new FirebaseRecyclerAdapter<ModelRequest, OrderViewHolder>(
                ModelRequest.class,
                R.layout.order_layout,
                OrderViewHolder.class,
                databaseReference.orderByChild("telepon").equalTo(telepon)
        ) {
            @Override
            protected void populateViewHolder(OrderViewHolder orderViewHolder, ModelRequest modelRequest, int i) {
                orderViewHolder.txtOrderId.setText(adapter.getRef(i).getKey());
                orderViewHolder.txtOrderStatus.setText(convertCodeToStatus(modelRequest.getStatus()));
                orderViewHolder.txtOrderAddress.setText(modelRequest.getAlamat());
                orderViewHolder.txtOrderPhone.setText(modelRequest.getTelepon());
            }
        };

        recyclerView.setAdapter(adapter);
    }

    private String convertCodeToStatus(String status) {
        if (status.equals("0")){
            return "Placed";
        }
        else if (status.equals("1")){
            return "On my way";
        }
        else{
            return "Shipped";
        }
    }
}
