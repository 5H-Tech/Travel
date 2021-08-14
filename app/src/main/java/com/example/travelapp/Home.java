/*package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}*/
package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    String choise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button airplane_choise,train_choise,bus_choise,ticket_choise;
        airplane_choise=(Button) findViewById(R.id.Airplane_ID);
        train_choise=(Button) findViewById(R.id.Train_ID);
        bus_choise=(Button) findViewById(R.id.Bus_ID);
        ticket_choise=(Button) findViewById(R.id.Ticket_ID);

        //ON Click

        airplane_choise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choise="Airplane";
                Intent intent =new Intent(v.getContext(),Show_travilsActivity.class);
                startActivity(intent);
                Toast.makeText(Home.this,"your transport is "+choise,Toast.LENGTH_LONG).show();
            }
        });
        train_choise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choise="Traine";
                Intent intent =new Intent(v.getContext(),Show_travilsActivity.class);
                startActivity(intent);
                Toast.makeText(Home.this,"your transport is "+choise,Toast.LENGTH_LONG).show();
            }
        });
        ticket_choise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choise="Ticket";
                Intent intent =new Intent(v.getContext(),Show_travilsActivity.class);
                startActivity(intent);
                Toast.makeText(Home.this,"your transport is "+choise,Toast.LENGTH_LONG).show();
            }
        });
        bus_choise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choise="Bus";
                Intent intent =new Intent(v.getContext(),Show_travilsActivity.class);
                startActivity(intent);
                Toast.makeText(Home.this,"your transport is "+choise,Toast.LENGTH_SHORT).show();

            }
        });
    }
}