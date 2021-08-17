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
import android.widget.ListAdapter;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    String choise;
    static boolean is_air = false, is_bus = false, is_train = false, is_ticket = false;
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
                List<Trip> airplane_trips=new ArrayList<>();
                airplane_trips.clear();
                for (int i=0;i<MainActivity.trips.size();i++){
                    if(MainActivity.trips.get(i).getPhoto()==R.drawable.ic_airplane_24dp){
                        airplane_trips.add(MainActivity.trips.get(i));
                    }
                }
                Show_travilsActivity.Destination=airplane_trips;
                Intent intent =new Intent(v.getContext(),Destination.class);
                startActivity(intent);
                Toast.makeText(Home.this,"your transport is "+choise,Toast.LENGTH_LONG).show();
                is_air = true;
                is_bus=false;
                is_ticket=false;
                is_train=false;

            }
        });
        train_choise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choise="Traine";
                List<Trip> train_trips=new ArrayList<>();
                train_trips.clear();
                for (int i=0;i<MainActivity.trips.size();i++){
                    if(MainActivity.trips.get(i).getPhoto()==R.drawable.ic_train_60){
                        train_trips.add(MainActivity.trips.get(i));
                    }
                }
                Show_travilsActivity.Destination=train_trips;
                Intent intent =new Intent(v.getContext(),Destination.class);
                startActivity(intent);
                Toast.makeText(Home.this,"your transport is "+choise,Toast.LENGTH_LONG).show();
                is_train = true;
                is_bus=false;
                is_ticket=false;
                is_air=false;
            }
        });
        ticket_choise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choise="Ticket";
                Intent intent =new Intent(v.getContext(),Destination.class);
                startActivity(intent);
                Toast.makeText(Home.this,"your "+choise,Toast.LENGTH_LONG).show();
                is_ticket = true;
                is_bus=false;
                is_air=false;
                is_train=false;
            }
        });
        bus_choise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choise="Bus";
                List<Trip> Bus_trips=new ArrayList<>();
                Bus_trips.clear();
                for (int i=0;i<MainActivity.trips.size();i++){
                    if(MainActivity.trips.get(i).getPhoto()==R.drawable.ic_bus_50){
                        Bus_trips.add(MainActivity.trips.get(i));
                    }
                }
                Show_travilsActivity.Destination=Bus_trips;
                Intent intent =new Intent(v.getContext(),Destination.class);
                startActivity(intent);
                Toast.makeText(Home.this,"your transport is "+choise,Toast.LENGTH_SHORT).show();
                is_bus = true;
                is_air=false;
                is_ticket=false;
                is_train=false;
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