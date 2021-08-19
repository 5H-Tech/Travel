package com.example.travelapp;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {
    public List<Trip> mylist;

    public CartAdapter(List<Trip> mylist) {
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public CartAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_booked_tickets,parent,false);
        return new CartAdapter.MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.MyViewHolder holder, int position) {
        Trip trip = mylist.get(position);
        holder.travel_img.setImageResource(trip.getPhoto());
        holder.from.setText(trip.getFrom());
        holder.to.setText(trip.getTo());
        holder.price.setText(String.valueOf(trip.getPrice()));
        holder.time.setText(trip.getTime());
        holder.quantity.setText(String.valueOf(trip.quantity));
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView from, to, price, time;
        EditText quantity;
        ImageView add,remove;
        ImageView travel_img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            travel_img=itemView.findViewById(R.id.carttravel_img_id);
            from=itemView.findViewById(R.id.cartfromtextid);
            to =itemView.findViewById(R.id.carttotextid);
            price = itemView.findViewById(R.id.cartpricetextid);
            time=itemView.findViewById(R.id.carttimetextid);
            quantity = itemView.findViewById(R.id.tec_count_cart);
            add=itemView.findViewById(R.id.img_add_cart);
            remove=itemView.findViewById(R.id.img_remove_cart);
        }
    }
}
