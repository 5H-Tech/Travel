package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

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

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent intent=new Intent(getApplication(),Profile.class);
                startActivity(intent);
                return true;
            case R.id.item2:
                Intent intent1=new Intent(getApplication(),About.class);
                startActivity(intent1);
                return true;
            case R.id.item3:
                Intent intentt=new Intent(getApplication(),MainActivity.class);
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(intentt);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}