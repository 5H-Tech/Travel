package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

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
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent intent=new Intent(getApplication(),Profile.class);
                startActivity(intent);
                return true;
            case R.id.item2:
                Toast.makeText(this,"this is information obut us",Toast.LENGTH_SHORT).show();
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