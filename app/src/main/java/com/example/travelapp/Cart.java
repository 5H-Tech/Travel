package com.example.travelapp;

import com.example.travelapp.Trip;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    String useer_id;
    String trip_id;
    int quantity;

    public Cart(String useer_id, String trip_id, int quantity) {
        this.useer_id = useer_id;
        this.trip_id = trip_id;
        this.quantity = quantity;
    }

    public Cart(String useer_id) {
        this.useer_id = useer_id;
    }
}
