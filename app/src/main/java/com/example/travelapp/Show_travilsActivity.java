package com.example.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Show_travilsActivity extends AppCompatActivity {

    RecyclerView travilsview;
    Adpter travilsAdpter;
    static List<Trip>Destination=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_travils);



        travilsview=findViewById(R.id.recyclerview);
        travilsAdpter = new Adpter(Destination);
        RecyclerView.LayoutManager mylayoutmanager = new LinearLayoutManager(getApplicationContext());
        travilsview.setLayoutManager(mylayoutmanager);
        travilsview.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        travilsview.setAdapter(travilsAdpter);
        travilsview.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), travilsview, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent i=new Intent(Show_travilsActivity.this,Trip_Details.class);
                Trip t=MainActivity.trips.get(position);
                Trip_Details.from=t.getFrom();
                Trip_Details.to=t.getTo();
                Trip_Details.price=t.getPrice();
                Trip_Details.time=t.getTime();
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {
                Trip t=MainActivity.trips.get(position);
                Toast.makeText(view.getContext(), t.from+" -> "+t.to, Toast.LENGTH_LONG).show();
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
