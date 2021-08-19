package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShowCartTrips extends AppCompatActivity {
    RecyclerView carttravilsview;
    CartAdapter carttravilsAdpter;
    static List<Trip> cartlist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cart_trips);

        carttravilsview=findViewById(R.id.cartrecyclerview);
        carttravilsAdpter = new CartAdapter(cartlist);
        RecyclerView.LayoutManager mylayoutmanager = new LinearLayoutManager(getApplicationContext());
        carttravilsview.setLayoutManager(mylayoutmanager);
        carttravilsview.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        carttravilsview.setAdapter(carttravilsAdpter);
        carttravilsview.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), carttravilsview, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }
}