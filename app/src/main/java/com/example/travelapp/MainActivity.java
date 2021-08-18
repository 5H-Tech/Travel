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
//        Trip t=new Trip("Egypt", "Egypt", 180000, "30/9/2021", R.drawable.ic_airplane_24dp,15);
//        trips.add(t);
//        t=new Trip("France", "Italy", 25000, "5/10/2021", R.drawable.ic_airplane_24dp,15);
//        trips.add(t);
//        t=new Trip("Russia", "Spain", 20000, "30/9/2021", R.drawable.ic_airplane_24dp,37);
//        trips.add(t);
//        t=new Trip("Germany", "italy", 18000, "5/11/2021", R.drawable.ic_airplane_24dp,30);
//        trips.add(t);
//        t=new Trip("Germany", "Spain", 17000, "5/10/2021", R.drawable.ic_airplane_24dp,30);
//        trips.add(t);
//        t=new Trip("Egypt", "Saudi Arabi", 30000, "5/11/2021", R.drawable.ic_airplane_24dp,7);
//        trips.add(t);
//        t=new Trip("Syria", "Saudi Arabi", 14000, "30/9/2021", R.drawable.ic_airplane_24dp,10);
//        trips.add(t);
//        t=new Trip("Palestine", "Syria", 16000, "5/10/2021", R.drawable.ic_airplane_24dp,12);
//        trips.add(t);
//        t=new Trip("Iraq", "China", 18000, "5/11/2021", R.drawable.ic_airplane_24dp,15);
//        trips.add(t);
//        t=new Trip("Iraq", "Palestin", 17000, "30/9/2021", R.drawable.ic_airplane_24dp,10);
//        trips.add(t);
//        t=new Trip("Egypt", "Morocco", 20000, "30/9/2021", R.drawable.ic_airplane_24dp,13);
//        trips.add(t);
//        t=new Trip("Tunisiae", "Morocco", 15000, "30/9/2021", R.drawable.ic_airplane_24dp,16);
//        trips.add(t);
//        t=new Trip("United Kingdom", "Liby", 19000, "30/9/2021", R.drawable.ic_airplane_24dp,24);
//        trips.add(t);
//        t=new Trip("Liby", "Tunisiae", 14000, "30/9/2021", R.drawable.ic_airplane_24dp,19);
//        trips.add(t);
//        t=new Trip("Spain", "Syria", 240000, "30/9/2021", R.drawable.ic_airplane_24dp,15);
//        trips.add(t);
//        t=new Trip("italy", "Iraq", 230000, "30/9/2021", R.drawable.ic_airplane_24dp,37);
//        trips.add(t);
//        t=new Trip("Russia", "China", 280000, "30/9/2021", R.drawable.ic_airplane_24dp,30);
//        trips.add(t);
//        t=new Trip("Germany", "Palestin", 270000, "30/9/2021", R.drawable.ic_airplane_24dp,30);
//        trips.add(t);
//        t=new Trip("Franc", "Saudi Arabi", 290000, "30/9/2021", R.drawable.ic_airplane_24dp,15);
//        trips.add(t);
//        t=new Trip("Spain", "Tunisiae", 140000, "30/9/2021", R.drawable.ic_airplane_24dp,15);
//        trips.add(t);
//        t=new Trip("italy", "Morocco", 120000, "30/9/2021", R.drawable.ic_airplane_24dp,37);
//        trips.add(t);
//        t=new Trip("Russia", "Liby", 140000, "30/9/2021", R.drawable.ic_airplane_24dp,30);
//        trips.add(t);
//        t=new Trip("Germany", "United Kingdom", 180000, "30/9/2021", R.drawable.ic_airplane_24dp,30);
//        trips.add(t);
//        t=new Trip("Franc", "United Kingdom", 160000, "30/9/2021", R.drawable.ic_airplane_24dp,30);
//        trips.add(t);
//        t=new Trip("Iraq", "Tunisiae", 80000, "30/9/2021", R.drawable.ic_airplane_24dp,15);
//        trips.add(t);
//        t=new Trip("China", "Morocco", 50000, "30/9/2021", R.drawable.ic_airplane_24dp,37);
//        trips.add(t);
//        t=new Trip("Syria", "Liby", 60000, "30/9/2021", R.drawable.ic_airplane_24dp,30);
//        trips.add(t);
//        t=new Trip("Saudi Arabi", "United Kingdom", 77000, "30/9/2021", R.drawable.ic_airplane_24dp,30);
//        trips.add(t);
//        t=new Trip("Palestin", "United Kingdom", 59000, "30/9/2021", R.drawable.ic_airplane_24dp,30);
//
//
//
////        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_bus_50,100);
////        trips.add(t);
////        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_train_60,150);
////        trips.add(t);
////        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_bus_50,200);
////        trips.add(t);
////        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_airplane_24dp,30);
////        trips.add(t);
////        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_train_60,66);
////        trips.add(t);
////        t=new Trip("Egypt", "italy", 15, "30/9", R.drawable.ic_bus_50,120);
////        trips.add(t);
//        //***************************************************************************************************************
//        t=new Trip("Egypt", "France", 180000, "30/9/2021", R.drawable.ic_train_60,15);
//        trips.add(t);
//        t=new Trip("Franc", "italy", 25000, "5/10/2021", R.drawable.ic_train_60,15);
//        trips.add(t);
//        t=new Trip("Russia", "Spain", 20000, "30/9/2021", R.drawable.ic_train_60,37);
//        trips.add(t);
//        t=new Trip("Germany", "italy", 18000, "5/11/2021", R.drawable.ic_train_60,30);
//        trips.add(t);
//        t=new Trip("Germany", "Spain", 17000, "5/10/2021", R.drawable.ic_train_60,30);
//        trips.add(t);
//        t=new Trip("Egypt", "Saudi Arabi", 30000, "5/11/2021", R.drawable.ic_train_60,7);
//        trips.add(t);
//        t=new Trip("Syria", "Saudi Arabi", 14000, "30/9/2021", R.drawable.ic_train_60,10);
//        trips.add(t);
//        t=new Trip("Palestine", "Syria", 16000, "5/10/2021", R.drawable.ic_train_60,12);
//        trips.add(t);
//        t=new Trip("Iraq", "China", 18000, "5/11/2021", R.drawable.ic_train_60,15);
//        trips.add(t);
//        t=new Trip("Iraq", "Palestin", 17000, "30/9/2021", R.drawable.ic_train_60,10);
//        trips.add(t);
//        t=new Trip("Egypt", "Morocco", 20000, "30/9/2021", R.drawable.ic_train_60,13);
//        trips.add(t);
//        t=new Trip("Tunisiae", "Morocco", 15000, "30/9/2021", R.drawable.ic_train_60,16);
//        trips.add(t);
//        t=new Trip("United Kingdom", "Liby", 19000, "30/9/2021", R.drawable.ic_train_60,24);
//        trips.add(t);
//        t=new Trip("Liby", "Tunisiae", 14000, "30/9/2021", R.drawable.ic_train_60,19);
//        trips.add(t);
//        t=new Trip("Spain", "Syria", 240000, "30/9/2021", R.drawable.ic_train_60,15);
//        trips.add(t);
//        t=new Trip("italy", "Iraq", 230000, "30/9/2021", R.drawable.ic_train_60,37);
//        trips.add(t);
//        t=new Trip("Russia", "China", 280000, "30/9/2021", R.drawable.ic_train_60,30);
//        trips.add(t);
//        t=new Trip("Germany", "Palestin", 270000, "30/9/2021", R.drawable.ic_train_60,30);
//        trips.add(t);
//        t=new Trip("Franc", "Saudi Arabi", 290000, "30/9/2021", R.drawable.ic_train_60,15);
//        trips.add(t);
//        t=new Trip("Spain", "Tunisiae", 140000, "30/9/2021", R.drawable.ic_train_60,15);
//        trips.add(t);
//        t=new Trip("italy", "Morocco", 120000, "30/9/2021", R.drawable.ic_train_60,37);
//        trips.add(t);
//        t=new Trip("Russia", "Liby", 140000, "30/9/2021", R.drawable.ic_train_60,30);
//        trips.add(t);
//        t=new Trip("Germany", "United Kingdom", 180000, "30/9/2021", R.drawable.ic_train_60,30);
//        trips.add(t);
//        t=new Trip("Franc", "United Kingdom", 160000, "30/9/2021", R.drawable.ic_train_60,30);
//        trips.add(t);
//        t=new Trip("Iraq", "Tunisiae", 80000, "30/9/2021", R.drawable.ic_train_60,15);
//        trips.add(t);
//        t=new Trip("China", "Morocco", 50000, "30/9/2021", R.drawable.ic_train_60,37);
//        trips.add(t);
//        t=new Trip("Syria", "Liby", 60000, "30/9/2021", R.drawable.ic_train_60,30);
//        trips.add(t);
//        t=new Trip("Saudi Arabi", "United Kingdom", 77000, "30/9/2021", R.drawable.ic_train_60,30);
//        trips.add(t);
//        t=new Trip("Palestin", "United Kingdom", 59000, "30/9/2021", R.drawable.ic_train_60,30);
////****************************************************************************************************************************************
//        t=new Trip("Cairo", "Alexandria", 180, "30/9/2021", R.drawable.ic_bus_50,15);
//        trips.add(t);
//        t=new Trip("Alexandria", "Aswan", 250, "5/10/2021", R.drawable.ic_bus_50,15);
//        trips.add(t);
//        t=new Trip("Aswan", "Fayoum", 20000, "30/9/2021", R.drawable.ic_bus_50,37);
//        trips.add(t);
//        t=new Trip("Fayoum", "Cairo", 18000, "5/11/2021", R.drawable.ic_bus_50,30);
//        trips.add(t);
//        t=new Trip("Alexandria", "Luxor", 17000, "5/10/2021", R.drawable.ic_bus_50,30);
//        trips.add(t);
//        t=new Trip("Fayoum", "Cairo", 30000, "5/11/2021", R.drawable.ic_bus_50,7);
//        trips.add(t);
//        t=new Trip("Luxor", "Aswan", 14000, "30/9/2021", R.drawable.ic_bus_50,10);
//        trips.add(t);
//        t=new Trip("Cairo", "Aswan", 16000, "5/10/2021", R.drawable.ic_bus_50,12);
//        trips.add(t);
//        t=new Trip("Fayoum", "Luxor", 18000, "5/11/2021", R.drawable.ic_bus_50,15);
//        trips.add(t);
//        t=new Trip("Aswan", "Alexandria", 17000, "30/9/2021", R.drawable.ic_bus_50,10);
//        trips.add(t);
//        t=new Trip("Luxor", "Alexandria", 20000, "30/9/2021", R.drawable.ic_bus_50,13);
//        trips.add(t);
//        t=new Trip("Cairo", "Fayoum", 15000, "30/9/2021", R.drawable.ic_bus_50,16);
//        trips.add(t);
//        t=new Trip("Alexandria", "Fayoum", 19000, "30/9/2021", R.drawable.ic_bus_50,24);
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