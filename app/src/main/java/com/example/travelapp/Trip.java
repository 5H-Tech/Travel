package com.example.travelapp;

import android.widget.ImageView;

public class Trip {
    String from, to, time, id;
    int photo,price,quantity;

    public Trip(String id, String from, String to, int price, String time, int photo,int quantity) {
        this.from = from;
        this.to = to;
        this.price = price;
        this.time = time;
        this.photo = photo;
        this.quantity=quantity;
        this.id=id;
    }

    public Trip(){

    }


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
