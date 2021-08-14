package com.example.travelapp;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adpter extends RecyclerView.Adapter<Adpter.MyViewHolder>  {

    public List<Trip> mylist;
    public  static  boolean  f;
    public static Trip p;
    public static int pos;
    public Adpter(List<Trip> mylist) {
        this.mylist = mylist;
    }

//////////////////////////////////////////////////////////////////////////////////////////////

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_travil_item,parent,false);
        return new MyViewHolder(itemview);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Trip trip = mylist.get(position);

            holder.travel_img.setImageResource(trip.getPhoto());
            holder.from.setText(trip.getFrom());
            holder.to.setText(trip.getTo());
            holder.price.setText(String.valueOf(trip.getPrice()));
            holder.time.setText(trip.getTime());
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public int getItemCount()
    {
        return mylist.size();
    }//enetitemcountgd


    private void finissh(Activity c) {
        c.finish();
        c.startActivity(c.getIntent());
    }




////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView  from, to, price, time;
        ImageView travel_img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            travel_img=itemView.findViewById(R.id.travel_img_id);
            from=itemView.findViewById(R.id.fromtextid);
            to =itemView.findViewById(R.id.totextid);
            price = itemView.findViewById(R.id.pricetextid);
            time=itemView.findViewById(R.id.timetextid);

        }
    }
}//end adpter
