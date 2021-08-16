package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Trip_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_details);

        ImageView transport_view = (ImageView)findViewById(R.id.Transport_id);
        TextView from = (TextView)findViewById(R.id.tv_from);
        TextView to = (TextView)findViewById(R.id.tv_to);
        TextView price = (TextView)findViewById(R.id.tv_price);
        TextView time = (TextView)findViewById(R.id.tv_time);
        Button book = (Button)findViewById(R.id.booking);

        Home h = new Home();
        Trip t = new Trip();
        if(h.is_bus){
            transport_view.setImageResource(R.drawable.ic_bus_50);
        }
        else if(h.is_air){
            transport_view.setImageResource(R.drawable.ic_airplane_24dp);
        }
        else if(h.is_train){
            transport_view.setImageResource(R.drawable.ic_train_60);
        }
        else if(h.is_ticket){
            transport_view.setImageResource(R.drawable.ic_ticket_50);
        }
    }
}