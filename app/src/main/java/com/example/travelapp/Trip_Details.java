package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Trip_Details extends AppCompatActivity {
    static String from, to, time;
    static int photo,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_details);

        ImageView transport_view = (ImageView)findViewById(R.id.Transport_id);
        TextView from_txt = (TextView)findViewById(R.id.tv_from);
        TextView to_txt = (TextView)findViewById(R.id.tv_to);
        TextView price_txt = (TextView)findViewById(R.id.tv_price);
        TextView time_txt = (TextView)findViewById(R.id.tv_time);
        Button book = (Button)findViewById(R.id.booking);

        Trip t = new Trip();
        if(Home.is_bus){
            transport_view.setImageResource(R.drawable.ic_bus_50);
        }
        else if(Home.is_air){
            transport_view.setImageResource(R.drawable.ic_airplane_24dp);
        }
        else if(Home.is_train){
            transport_view.setImageResource(R.drawable.ic_train_60);
        }
        else if(Home.is_ticket){
            transport_view.setImageResource(R.drawable.ic_ticket_50);
        }

        from_txt.setText(from);
        to_txt.setText(to);
        price_txt.setText(String.valueOf(price));
        time_txt.setText(time);
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