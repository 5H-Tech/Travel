package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    static List<Trip> trips=new ArrayList<>();
    static List<Cart> carts=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Trip t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_train_60,9);
        trips.add(t);
        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_airplane_24dp,10);
        trips.add(t);
//        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_bus_50,100);
//        trips.add(t);
//        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_train_60,150);
//        trips.add(t);
//        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_bus_50,200);
//        trips.add(t);
//        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_airplane_24dp,30);
//        trips.add(t);
//        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_train_60,66);
//        trips.add(t);
//        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_bus_50,120);
//        trips.add(t);
        Button b1 = findViewById(R.id.btn1);
        TextView sin_Up = findViewById(R.id.signup_tv);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SignIn.class);
                startActivityForResult(intent, 0);
            }
        });
        sin_Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SignUp.class);
                startActivityForResult(intent, 0);
            }
        });
    }

}