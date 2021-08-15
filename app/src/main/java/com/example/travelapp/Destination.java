package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Destination extends AppCompatActivity {
    public String s_from;
    public String s_to;
    EditText t_from ;
    EditText t_to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        t_from= findViewById(R.id.editText_from);
        t_to = findViewById(R.id.editText_to);

        Button btn_mytrip = findViewById(R.id.btn_MyTrip);
        Button btn_alltrips = findViewById(R.id.btn_AllTrips);

        btn_mytrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Destination.this, Show_travilsActivity.class);
                startActivity(i);
            }
        });

        btn_alltrips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Destination.this, Show_travilsActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return true;
    }
}