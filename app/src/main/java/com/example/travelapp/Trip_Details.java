package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
}