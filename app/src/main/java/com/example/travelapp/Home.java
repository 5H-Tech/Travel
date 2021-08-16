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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
                Intent intent =new Intent(v.getContext(),Destination.class);
                startActivity(intent);
                Toast.makeText(Home.this,"your transport is "+choise,Toast.LENGTH_LONG).show();
            }
        });
        train_choise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choise="Traine";
                Intent intent =new Intent(v.getContext(),Destination.class);
                startActivity(intent);
                Toast.makeText(Home.this,"your transport is "+choise,Toast.LENGTH_LONG).show();
            }
        });
        ticket_choise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choise="Ticket";
                Intent intent =new Intent(v.getContext(),Destination.class);
                startActivity(intent);
                Toast.makeText(Home.this,"your "+choise,Toast.LENGTH_LONG).show();
            }
        });
        bus_choise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choise="Bus";
                Intent intent =new Intent(v.getContext(),Destination.class);
                startActivity(intent);
                Toast.makeText(Home.this,"your transport is "+choise,Toast.LENGTH_SHORT).show();

            }
        });

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