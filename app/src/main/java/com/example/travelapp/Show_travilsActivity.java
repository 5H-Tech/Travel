package com.example.travelapp;

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

import java.util.ArrayList;
import java.util.List;

public class Show_travilsActivity extends AppCompatActivity {
    RecyclerView travilsview;
    Adpter travilsAdpter;
    List<Trip> trips=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_travils);
        Trip t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_train_60);
        trips.add(t);
        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_airplane_24dp);
        trips.add(t);
        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_bus_50);
        trips.add(t);
        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_train_60);
        trips.add(t);
        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_bus_50);
        trips.add(t);
        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_airplane_24dp);
        trips.add(t);
        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_train_60);
        trips.add(t);
        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_bus_50);
        trips.add(t);


        travilsview=findViewById(R.id.recyclerview);
        travilsAdpter = new Adpter(trips);
        RecyclerView.LayoutManager mylayoutmanager = new LinearLayoutManager(getApplicationContext());
        travilsview.setLayoutManager(mylayoutmanager);
        travilsview.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        travilsview.setAdapter(travilsAdpter);
        travilsview.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), travilsview, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Trip t=trips.get(position);
                Toast.makeText(getApplicationContext(), String.valueOf(t.getPrice()), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Trip t=trips.get(position);
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
                Toast.makeText(this,"this is your profile",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this,"this is information obut us",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this,"you logged out",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
