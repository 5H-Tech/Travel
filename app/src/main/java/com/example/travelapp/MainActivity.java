package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

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
        /*Trip t=new Trip("Egypt", "Italy", 18000, "22/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Egypt ", "Russia", 25000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Egypt ", "Saudi Arabia", 15000, "17/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt ", "Libya", 15000, "5/11/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt ", "France", 17000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt", "Spain", 17000, "5/7/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt ", "China", 14000, "4/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt ", "Palestine", 16000, "5/4/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt ", "Morocco", 18000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt ", "Germany", 17000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);




        t=new Trip("Italy", "Egypt", 18000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Italy ", "Russia", 30000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Italy ", "Saudi Arabia", 20000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy ", "Libya", 18000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy ", "France", 17000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy", "Spain", 30000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy ", "China", 35000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy ", "Palestine", 16000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy ", "Morocco", 18000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy ", "Germany", 17000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);



        t=new Trip("Russia", "Egypt", 40000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Russia ", "Italy", 30000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Russia ", "Saudi Arabia", 25000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia ", "Libya", 30000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia ", "France", 17000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia", "Spain", 30000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia ", "China", 25000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia ", "Palestine", 27000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia ", "Morocco", 37000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia ", "Germany", 36000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);


        t=new Trip("Saudi Arabia", "Egypt", 18000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Saudi Arabia ", "Italy", 25000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Saudi Arabia ", "Russia", 20000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Libya", 18000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "France", 17000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia", "Spain", 20000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "China", 14000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Palestine", 16000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Morocco", 18000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Germany", 17000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);


        t=new Trip("Libya", "Egypt", 18000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Libya ", "Italy", 25000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Libya ", "Saudi Arabia", 20000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya ", "Russia", 18000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya ", "France", 17000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya", "Spain", 14000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya ", "China", 30000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya ", "Palestine", 16000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya ", "Morocco", 18000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya ", "Germany", 17000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);



        t=new Trip("France", "Egypt", 18000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" France ", "Italy", 25000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" France ", "Saudi Arabia", 20000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France ", "Russia", 38000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France ", "Libya", 17000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France", "Spain", 30000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France ", "China", 34000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France ", "Palestine", 16000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France ", "Morocco", 18000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France ", "Germany", 17000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);



        t=new Trip("Spain", "Egypt", 180000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Spain ", "Italy", 25000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Spain ", "Saudi Arabia", 20000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain ", "Russia", 25000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain ", "Libya", 17000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain", "France", 30000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain ", "China", 25000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain ", "Palestine", 16000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain ", "Morocco", 18000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain ", "Germany", 17000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);


        t=new Trip("China", "Egypt", 25000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" China ", "Italy", 25000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" China ", "Saudi Arabia", 20000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China ", "Russia", 18000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China ", "Libya", 17000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China", "France", 25000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China ", "Spain", 30000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China ", "Palestine", 16000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China ", "Morocco", 18000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China ", "Germany", 17000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);







        t=new Trip("Palestine", "Egypt", 15000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Palestine ", "Italy", 25000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Palestine ", "Saudi Arabia", 20000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine ", "Russia", 18000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine ", "Libya", 17000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine", "France", 30000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine ", "Spain", 14000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine ", "China", 16000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine ", "Morocco", 18000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine ", "Germany", 17000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);



        t=new Trip("Morocco", "Egypt", 18000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Morocco ", "Italy", 25000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Morocco ", "Saudi Arabia", 20000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Morocco ", "Russia", 18000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Morocco ", "Libya", 17000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Morocco", "France", 30000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Morocco ", "Spain", 14000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Morocco ", "China", 16000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Morocco ", "Plestine", 18000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Morocco ", "Germany", 17000, "30/9/2021", R.drawable.ic_airplane_24dp,20);
        trips.add(t);



        t=new Trip("Germany", "Egypt", 18000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Germany ", "Italy", 25000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Germany ", "Saudi Arabia", 20000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Germany ", "Russia", 15000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Germany ", "Libya", 17000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Germany", "France", 30000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Germany ", "Spain", 14000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Germany ", "China", 16000, "5/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Germany ", "Plestine", 18000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Germany ", "Morocco", 17000, "30/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);









        //Airplane///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        t=new Trip("Egypt", "Italy", 18000, "22/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Egypt ", "Russia", 25000, "5/11/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Egypt ", "Saudi Arabia", 15000, "17/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt ", "Libya", 15000, "5/10/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt ", "France", 17000, "5/5/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt", "Spain", 17000, "5/7/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt ", "China", 14000, "4/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt ", "Palestine", 16000, "27/4/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt ", "Morocco", 18000, "31/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt ", "Germany", 17000, "30/4/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);




        t=new Trip("Italy", "Egypt", 18000, "30/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Italy ", "Russia", 30000, "5/6/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Italy ", "Saudi Arabia", 20000, "3/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy ", "Libya", 18000, "5/7/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy ", "France", 17000, "4/10/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy", "Spain", 30000, "16/7/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy ", "China", 35000, "25/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy ", "Palestine", 16000, "21/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy ", "Morocco", 18000, "28/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy ", "Germany", 17000, "2/2/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);



        t=new Trip("Russia", "Egypt", 40000, "30/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Russia ", "Italy", 30000, "5/8/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Russia ", "Saudi Arabia", 25000, "30/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia ", "Libya", 30000, "9/11/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia ", "France", 17000, "16/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia", "Spain", 30000, "23/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia ", "China", 25000, "30/12/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia ", "Palestine", 27000, "13/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia ", "Morocco", 37000, "29/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia ", "Germany", 36000, "25/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);


        t=new Trip("Saudi Arabia", "Egypt", 18000, "4/4/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Saudi Arabia ", "Italy", 25000, "13/3/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Saudi Arabia ", "Russia", 20000, "28/2/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Libya", 18000, "31/3/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "France", 17000, "25/4/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia", "Spain", 20000, "15/7/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "China", 14000, "30/8/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Palestine", 16000, "5/11/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Morocco", 18000, "9/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Germany", 17000, "29/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);


        t=new Trip("Libya", "Egypt", 18000, "31/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Libya ", "Italy", 25000, "15/7/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Libya ", "Saudi Arabia", 20000, "30/1/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya ", "Russia", 18000, "5/2/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya ", "France", 17000, "5/6/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya", "Spain", 14000, "5/12/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya ", "China", 30000, "4/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya ", "Palestine", 16000, "5/10/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya ", "Morocco", 18000, "5/3/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya ", "Germany", 17000, "7/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);



        t=new Trip("France", "Egypt", 18000, "16/6/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" France ", "Italy", 25000, "23/7/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" France ", "Saudi Arabia", 20000, "27/1/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France ", "Russia", 38000, "29/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France ", "Libya", 17000, "14/5/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France", "Spain", 30000, "26/8/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France ", "China", 34000, "13/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France ", "Palestine", 16000, "27/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France ", "Morocco", 18000, "19/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France ", "Germany", 17000, "17/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);



        t=new Trip("Spain", "Egypt", 180000, "30/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Spain ", "Italy", 25000, "12/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Spain ", "Saudi Arabia", 20000, "9/2/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain ", "Russia", 25000, "7/1/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain ", "Libya", 17000, "5/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain", "France", 30000, "23/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain ", "China", 25000, "3/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain ", "Palestine", 16000, "6/5/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain ", "Morocco", 18000, "5/1/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain ", "Germany", 17000, "10/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);


        t=new Trip("China", "Egypt", 25000, "23/2/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" China ", "Italy", 25000, "10/7/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" China ", "Saudi Arabia", 20000, "16/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China ", "Russia", 18000, "15/12/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China ", "Libya", 17000, "8/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China", "France", 25000, "10/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China ", "Spain", 30000, "26/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China ", "Palestine", 16000, "21/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China ", "Morocco", 18000, "14/2/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China ", "Germany", 17000, "18/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);







        t=new Trip("Palestine", "Egypt", 15000, "12/6/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Palestine ", "Italy", 25000, "18/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Palestine ", "Saudi Arabia", 20000, "24/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine ", "Russia", 18000, "17/12/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine ", "Libya", 17000, "19/4/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine", "France", 30000, "3/3/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine ", "Spain", 14000, "11/7/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine ", "China", 16000, "21/5/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine ", "Morocco", 18000, "11/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine ", "Germany", 17000, "21/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);



        t=new Trip("Morocco", "Egypt", 18000, "3/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Morocco ", "Italy", 25000, "5/2/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Morocco ", "Saudi Arabia", 20000, "2/1/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Morocco ", "Russia", 18000, "4/8/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Morocco ", "Libya", 17000, "16/7/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Morocco", "France", 30000, "22/11/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Morocco ", "Spain", 14000, "30/6/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Morocco ", "China", 16000, "25/1/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Morocco ", "Plestine", 18000, "11/9/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Morocco ", "Germany", 17000, "14/7/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);



        t=new Trip("Germany", "Egypt", 18000, "16/6/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Germany ", "Italy", 25000, "24/10/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Germany ", "Saudi Arabia", 20000, "27/4/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Germany ", "Russia", 15000, "25/12/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Germany ", "Libya", 17000, "5/4/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Germany", "France", 30000, "3/1/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Germany ", "Spain", 14000, "8/2/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Germany ", "China", 16000, "4/3/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Germany ", "Plestine", 18000, "7/1/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Germany ", "Morocco", 17000, "26/3/2021", R.drawable.ic_airplane_24dp,200);
        trips.add(t);




        //Airplane///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        t=new Trip("Egypt", "Italy", 18000, "22/9/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Egypt ", "Russia", 25000, "5/11/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Egypt ", "Saudi Arabia", 15000, "17/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt ", "Libya", 15000, "5/10/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt ", "France", 17000, "5/5/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt", "Spain", 17000, "5/7/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt ", "China", 14000, "4/9/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt ", "Palestine", 16000, "27/4/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt ", "Morocco", 18000, "31/11/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Egypt ", "Germany", 17000, "30/4/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);




        t=new Trip("Italy", "Egypt", 18000, "30/11/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Italy ", "Russia", 30000, "5/6/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Italy ", "Saudi Arabia", 20000, "3/9/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy ", "Libya", 18000, "5/7/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy ", "France", 17000, "4/10/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy", "Spain", 30000, "16/7/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy ", "China", 35000, "25/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy ", "Palestine", 16000, "21/10/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy ", "Morocco", 18000, "28/11/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Italy ", "Germany", 17000, "2/2/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);



        t=new Trip("Russia", "Egypt", 40000, "30/10/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Russia ", "Italy", 30000, "5/8/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Russia ", "Saudi Arabia", 25000, "30/9/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia ", "Libya", 30000, "9/11/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia ", "France", 17000, "16/10/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia", "Spain", 30000, "23/11/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia ", "China", 25000, "30/12/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia ", "Palestine", 27000, "13/10/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia ", "Morocco", 37000, "29/11/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Russia ", "Germany", 36000, "25/9/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);


        t=new Trip("Saudi Arabia", "Egypt", 18000, "4/4/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Saudi Arabia ", "Italy", 25000, "13/3/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Saudi Arabia ", "Russia", 20000, "28/2/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Libya", 18000, "31/3/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "France", 17000, "25/4/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia", "Spain", 20000, "15/7/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "China", 14000, "30/8/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Palestine", 16000, "5/11/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Morocco", 18000, "9/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Germany", 17000, "29/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);


        t=new Trip("Libya", "Egypt", 18000, "31/9/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Libya ", "Italy", 25000, "15/7/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Libya ", "Saudi Arabia", 20000, "30/1/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya ", "Russia", 18000, "5/2/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya ", "France", 17000, "5/6/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya", "Spain", 14000, "5/12/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya ", "China", 30000, "4/9/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya ", "Palestine", 16000, "5/10/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya ", "Morocco", 18000, "5/3/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Libya ", "Germany", 17000, "7/9/2023", R.drawable.ic_airplane_24dp,200);
        trips.add(t);



        t=new Trip("France", "Egypt", 18000, "16/6/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" France ", "Italy", 25000, "23/7/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" France ", "Saudi Arabia", 20000, "27/1/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France ", "Russia", 38000, "29/11/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France ", "Libya", 17000, "14/5/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France", "Spain", 30000, "26/8/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France ", "China", 34000, "13/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France ", "Palestine", 16000, "27/10/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France ", "Morocco", 18000, "19/11/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("France ", "Germany", 17000, "17/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);



        t=new Trip("Spain", "Egypt", 180000, "30/10/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Spain ", "Italy", 25000, "12/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Spain ", "Saudi Arabia", 20000, "9/2/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain ", "Russia", 25000, "7/1/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain ", "Libya", 17000, "5/11/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain", "France", 30000, "23/11/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain ", "China", 25000, "3/11/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain ", "Palestine", 16000, "6/5/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain ", "Morocco", 18000, "5/1/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Spain ", "Germany", 17000, "10/11/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);


        t=new Trip("China", "Egypt", 25000, "23/2/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" China ", "Italy", 25000, "10/7/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" China ", "Saudi Arabia", 20000, "16/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China ", "Russia", 18000, "15/12/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China ", "Libya", 17000, "8/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China", "France", 25000, "10/11/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China ", "Spain", 30000, "26/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China ", "Palestine", 16000, "21/10/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China ", "Morocco", 18000, "14/2/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("China ", "Germany", 17000, "18/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);







        t=new Trip("Palestine", "Egypt", 15000, "12/6/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Palestine ", "Italy", 25000, "18/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip(" Palestine ", "Saudi Arabia", 20000, "24/11/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine ", "Russia", 18000, "17/12/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine ", "Libya", 17000, "19/4/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine", "France", 30000, "3/3/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine ", "Spain", 14000, "11/7/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine ", "China", 16000, "21/5/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine ", "Morocco", 18000, "11/11/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);
        t=new Trip("Palestine ", "Germany", 17000, "21/9/2022", R.drawable.ic_airplane_24dp,200);
        trips.add(t);



        t=new Trip("Morocco", "Egypt", 18000, "3/9/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);
        t=new Trip(" Morocco ", "Italy", 25000, "5/2/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);
        t=new Trip(" Morocco ", "Saudi Arabia", 20000, "2/1/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);
        t=new Trip("Morocco ", "Russia", 18000, "4/8/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);
        t=new Trip("Morocco ", "Libya", 17000, "16/7/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);
        t=new Trip("Morocco", "France", 30000, "22/11/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);
        t=new Trip("Morocco ", "Spain", 14000, "30/6/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);
        t=new Trip("Morocco ", "China", 16000, "25/1/2021", R.drawable.ic_airplane_24dp,500);
        trips.add(t);
        t=new Trip("Morocco ", "Plestine", 18000, "11/9/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);
        t=new Trip("Morocco ", "Germany", 17000, "14/7/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);



        t=new Trip("Germany", "Egypt", 18000, "16/6/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);
        t=new Trip(" Germany ", "Italy", 25000, "24/10/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);
        t=new Trip(" Germany ", "Saudi Arabia", 20000, "27/4/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);
        t=new Trip("Germany ", "Russia", 15000, "25/12/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);
        t=new Trip("Germany ", "Libya", 17000, "5/4/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);
        t=new Trip("Germany", "France", 30000, "3/1/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);
        t=new Trip("Germany ", "Spain", 14000, "8/2/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);
        t=new Trip("Germany ", "China", 16000, "4/3/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);
        t=new Trip("Germany ", "Plestine", 18000, "7/1/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);
        t=new Trip("Germany ", "Morocco", 17000, "26/3/2022", R.drawable.ic_airplane_24dp,500);
        trips.add(t);



        //Train///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////##############################


        t=new Trip("Egypt", "Italy", 18000, "22/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip(" Egypt ", "Russia", 25000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip(" Egypt ", "Saudi Arabia", 15000, "17/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Egypt ", "Libya", 15000, "5/11/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Egypt ", "France", 17000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Egypt", "Spain", 17000, "5/7/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Egypt ", "China", 14000, "4/9/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Egypt ", "Palestine", 16000, "5/4/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Egypt ", "Morocco", 18000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Egypt ", "Germany", 17000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);




        t=new Trip("Italy", "Egypt", 18000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip(" Italy ", "Russia", 30000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip(" Italy ", "Saudi Arabia", 20000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Italy ", "Libya", 18000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Italy ", "France", 17000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Italy", "Spain", 30000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Italy ", "China", 35000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Italy ", "Palestine", 16000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Italy ", "Morocco", 18000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Italy ", "Germany", 17000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);



        t=new Trip("Russia", "Egypt", 40000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip(" Russia ", "Italy", 30000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip(" Russia ", "Saudi Arabia", 25000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Russia ", "Libya", 30000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Russia ", "France", 17000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Russia", "Spain", 30000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Russia ", "China", 25000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Russia ", "Palestine", 27000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Russia ", "Morocco", 37000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Russia ", "Germany", 36000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);


        t=new Trip("Saudi Arabia", "Egypt", 18000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip(" Saudi Arabia ", "Italy", 25000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip(" Saudi Arabia ", "Russia", 20000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Libya", 18000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "France", 17000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Saudi Arabia", "Spain", 20000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "China", 14000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Palestine", 16000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Morocco", 18000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Germany", 17000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);


        t=new Trip("Libya", "Egypt", 18000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip(" Libya ", "Italy", 25000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip(" Libya ", "Saudi Arabia", 20000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Libya ", "Russia", 18000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Libya ", "France", 17000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Libya", "Spain", 14000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Libya ", "China", 30000, "30/9/2021", R.drawable.ic_train_60,110);
        trips.add(t);
        t=new Trip("Libya ", "Palestine", 16000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Libya ", "Morocco", 18000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Libya ", "Germany", 17000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);



        t=new Trip("France", "Egypt", 18000, "30/9/2021", R.drawable.ic_train_60,150);
        trips.add(t);
        t=new Trip(" France ", "Italy", 25000, "5/10/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" France ", "Saudi Arabia", 20000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("France ", "Russia", 38000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("France ", "Libya", 17000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("France", "Spain", 30000, "5/11/2021", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("France ", "China", 34000, "30/9/2021", R.drawable.ic_train_60,110);
        trips.add(t);
        t=new Trip("France ", "Palestine", 16000, "5/10/2021", R.drawable.ic_train_60,112);
        trips.add(t);
        t=new Trip("France ", "Morocco", 18000, "5/11/2021", R.drawable.ic_train_60,115);
        trips.add(t);
        t=new Trip("France ", "Germany", 17000, "30/9/2021", R.drawable.ic_train_60,110);
        trips.add(t);



        t=new Trip("Spain", "Egypt", 180000, "30/9/2021", R.drawable.ic_train_60,115);
        trips.add(t);
        t=new Trip(" Spain ", "Italy", 25000, "5/10/2021", R.drawable.ic_train_60,115);
        trips.add(t);
        t=new Trip(" Spain ", "Saudi Arabia", 20000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Spain ", "Russia", 25000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Spain ", "Libya", 17000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Spain", "France", 30000, "5/11/2021", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Spain ", "China", 25000, "30/9/2021", R.drawable.ic_train_60,110);
        trips.add(t);
        t=new Trip("Spain ", "Palestine", 16000, "5/10/2021", R.drawable.ic_train_60,112);
        trips.add(t);
        t=new Trip("Spain ", "Morocco", 18000, "5/11/2021", R.drawable.ic_train_60,115);
        trips.add(t);
        t=new Trip("Spain ", "Germany", 17000, "30/9/2021", R.drawable.ic_train_60,110);
        trips.add(t);


        t=new Trip("China", "Egypt", 25000, "30/9/2021", R.drawable.ic_train_60,115);
        trips.add(t);
        t=new Trip(" China ", "Italy", 25000, "5/10/2021", R.drawable.ic_train_60,115);
        trips.add(t);
        t=new Trip(" China ", "Saudi Arabia", 20000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("China ", "Russia", 18000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("China ", "Libya", 17000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("China", "France", 25000, "5/11/2021", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("China ", "Spain", 30000, "30/9/2021", R.drawable.ic_train_60,110);
        trips.add(t);
        t=new Trip("China ", "Palestine", 16000, "5/10/2021", R.drawable.ic_train_60,112);
        trips.add(t);
        t=new Trip("China ", "Morocco", 18000, "5/11/2021", R.drawable.ic_train_60,115);
        trips.add(t);
        t=new Trip("China ", "Germany", 17000, "30/9/2021", R.drawable.ic_train_60,110);
        trips.add(t);







        t=new Trip("Palestine", "Egypt", 15000, "30/9/2021", R.drawable.ic_train_60,115);
        trips.add(t);
        t=new Trip(" Palestine ", "Italy", 25000, "5/10/2021", R.drawable.ic_train_60,115);
        trips.add(t);
        t=new Trip(" Palestine ", "Saudi Arabia", 20000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Palestine ", "Russia", 18000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Palestine ", "Libya", 17000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Palestine", "France", 30000, "5/11/2021", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Palestine ", "Spain", 14000, "30/9/2021", R.drawable.ic_train_60,110);
        trips.add(t);
        t=new Trip("Palestine ", "China", 16000, "5/10/2021", R.drawable.ic_train_60,112);
        trips.add(t);
        t=new Trip("Palestine ", "Morocco", 18000, "5/11/2021", R.drawable.ic_train_60,115);
        trips.add(t);
        t=new Trip("Palestine ", "Germany", 17000, "30/9/2021", R.drawable.ic_train_60,101);
        trips.add(t);



        t=new Trip("Morocco", "Egypt", 18000, "30/9/2021", R.drawable.ic_train_60,150);
        trips.add(t);
        t=new Trip(" Morocco ", "Italy", 25000, "5/10/2021", R.drawable.ic_train_60,150);
        trips.add(t);
        t=new Trip(" Morocco ", "Saudi Arabia", 20000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Morocco ", "Russia", 18000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Morocco ", "Libya", 17000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Morocco", "France", 30000, "5/11/2021", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Morocco ", "Spain", 14000, "30/9/2021", R.drawable.ic_train_60,110);
        trips.add(t);
        t=new Trip("Morocco ", "China", 16000, "5/10/2021", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("Morocco ", "Plestine", 18000, "5/11/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("Morocco ", "Germany", 17000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);



        t=new Trip("Germany", "Egypt", 18000, "30/9/2021", R.drawable.ic_train_60,150);
        trips.add(t);
        t=new Trip(" Germany ", "Italy", 25000, "5/10/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Germany ", "Saudi Arabia", 20000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Germany ", "Russia", 15000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Germany ", "Libya", 17000, "5/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Germany", "France", 30000, "5/11/2021", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Germany ", "Spain", 14000, "30/9/2021", R.drawable.ic_train_60,110);
        trips.add(t);
        t=new Trip("Germany ", "China", 16000, "5/10/2021", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("Germany ", "Plestine", 18000, "5/11/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("Germany ", "Morocco", 17000, "30/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);









        //Train///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////##################################


        t=new Trip("Egypt", "Italy", 18000, "22/9/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Egypt ", "Russia", 25000, "5/11/2023", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Egypt ", "Saudi Arabia", 15000, "17/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Egypt ", "Libya", 15000, "5/10/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Egypt ", "France", 17000, "5/5/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Egypt", "Spain", 17000, "5/7/2022", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Egypt ", "China", 14000, "4/9/2022", R.drawable.ic_train_60,110);
        trips.add(t);
        t=new Trip("Egypt ", "Palestine", 16000, "27/4/2021", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("Egypt ", "Morocco", 18000, "31/11/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("Egypt ", "Germany", 17000, "30/4/2022", R.drawable.ic_train_60,100);
        trips.add(t);




        t=new Trip("Italy", "Egypt", 18000, "30/11/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Italy ", "Russia", 30000, "5/6/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Italy ", "Saudi Arabia", 20000, "3/9/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Italy ", "Libya", 18000, "5/7/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Italy ", "France", 17000, "4/10/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Italy", "Spain", 30000, "16/7/2021", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Italy ", "China", 35000, "25/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Italy ", "Palestine", 16000, "21/10/2021", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("Italy ", "Morocco", 18000, "28/11/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("Italy ", "Germany", 17000, "2/2/2022", R.drawable.ic_train_60,100);
        trips.add(t);



        t=new Trip("Russia", "Egypt", 40000, "30/10/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Russia ", "Italy", 30000, "5/8/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Russia ", "Saudi Arabia", 25000, "30/9/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Russia ", "Libya", 30000, "9/11/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Russia ", "France", 17000, "16/10/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Russia", "Spain", 30000, "23/11/2021", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Russia ", "China", 25000, "30/12/2021", R.drawable.ic_train_60,110);
        trips.add(t);
        t=new Trip("Russia ", "Palestine", 27000, "13/10/2021", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("Russia ", "Morocco", 37000, "29/11/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("Russia ", "Germany", 36000, "25/9/2022", R.drawable.ic_train_60,110);
        trips.add(t);


        t=new Trip("Saudi Arabia", "Egypt", 18000, "4/4/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Saudi Arabia ", "Italy", 25000, "13/3/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Saudi Arabia ", "Russia", 20000, "28/2/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Libya", 18000, "31/3/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "France", 17000, "25/4/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Saudi Arabia", "Spain", 20000, "15/7/2021", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "China", 14000, "30/8/2022", R.drawable.ic_train_60,110);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Palestine", 16000, "5/11/2022", R.drawable.ic_train_60,112);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Morocco", 18000, "9/9/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Germany", 17000, "29/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);


        t=new Trip("Libya", "Egypt", 18000, "31/9/2022", R.drawable.ic_train_60,115);
        trips.add(t);
        t=new Trip(" Libya ", "Italy", 25000, "15/7/2021", R.drawable.ic_train_60,115);
        trips.add(t);
        t=new Trip(" Libya ", "Saudi Arabia", 20000, "30/1/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Libya ", "Russia", 18000, "5/2/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Libya ", "France", 17000, "5/6/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Libya", "Spain", 14000, "5/12/2021", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Libya ", "China", 30000, "4/9/2022", R.drawable.ic_train_60,110);
        trips.add(t);
        t=new Trip("Libya ", "Palestine", 16000, "5/10/2022", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("Libya ", "Morocco", 18000, "5/3/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("Libya ", "Germany", 17000, "7/9/2022", R.drawable.ic_train_60,110);
        trips.add(t);



        t=new Trip("France", "Egypt", 18000, "16/6/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" France ", "Italy", 25000, "23/7/2021", R.drawable.ic_train_60,150);
        trips.add(t);
        t=new Trip(" France ", "Saudi Arabia", 20000, "27/1/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("France ", "Russia", 38000, "29/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("France ", "Libya", 17000, "14/5/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("France", "Spain", 30000, "26/8/2021", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("France ", "China", 34000, "13/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("France ", "Palestine", 16000, "27/10/2021", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("France ", "Morocco", 18000, "19/11/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("France ", "Germany", 17000, "17/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);



        t=new Trip("Spain", "Egypt", 180000, "30/10/2021", R.drawable.ic_train_60,150);
        trips.add(t);
        t=new Trip(" Spain ", "Italy", 25000, "12/9/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Spain ", "Saudi Arabia", 20000, "9/2/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Spain ", "Russia", 25000, "7/1/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Spain ", "Libya", 17000, "5/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Spain", "France", 30000, "23/11/2021", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Spain ", "China", 25000, "3/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Spain ", "Palestine", 16000, "6/5/2021", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("Spain ", "Morocco", 18000, "5/1/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("Spain ", "Germany", 17000, "10/11/2021", R.drawable.ic_train_60,110);
        trips.add(t);


        t=new Trip("China", "Egypt", 25000, "23/2/2021", R.drawable.ic_train_60,115);
        trips.add(t);
        t=new Trip(" China ", "Italy", 25000, "10/7/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" China ", "Saudi Arabia", 20000, "16/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("China ", "Russia", 18000, "15/12/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("China ", "Libya", 17000, "8/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("China", "France", 25000, "10/11/2021", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("China ", "Spain", 30000, "26/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("China ", "Palestine", 16000, "21/10/2021", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("China ", "Morocco", 18000, "14/2/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("China ", "Germany", 17000, "18/9/2021", R.drawable.ic_train_60,110);
        trips.add(t);







        t=new Trip("Palestine", "Egypt", 15000, "12/6/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Palestine ", "Italy", 25000, "18/9/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Palestine ", "Saudi Arabia", 20000, "24/11/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Palestine ", "Russia", 18000, "17/12/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Palestine ", "Libya", 17000, "19/4/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Palestine", "France", 30000, "3/3/2021", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Palestine ", "Spain", 14000, "11/7/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Palestine ", "China", 16000, "21/5/2021", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("Palestine ", "Morocco", 18000, "11/11/2021", R.drawable.ic_train_60,150);
        trips.add(t);
        t=new Trip("Palestine ", "Germany", 17000, "21/9/2021", R.drawable.ic_train_60,100);
        trips.add(t);



        t=new Trip("Morocco", "Egypt", 18000, "3/9/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Morocco ", "Italy", 25000, "5/2/2021", R.drawable.ic_train_60,115);
        trips.add(t);
        t=new Trip(" Morocco ", "Saudi Arabia", 20000, "2/1/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Morocco ", "Russia", 18000, "4/8/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Morocco ", "Libya", 17000, "16/7/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Morocco", "France", 30000, "22/11/2021", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Morocco ", "Spain", 14000, "30/6/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Morocco ", "China", 16000, "25/1/2021", R.drawable.ic_train_60,112);
        trips.add(t);
        t=new Trip("Morocco ", "Plestine", 18000, "11/9/2021", R.drawable.ic_train_60,115);
        trips.add(t);
        t=new Trip("Morocco ", "Germany", 17000, "14/7/2021", R.drawable.ic_train_60,110);
        trips.add(t);



        t=new Trip("Germany", "Egypt", 18000, "16/6/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Germany ", "Italy", 25000, "24/10/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Germany ", "Saudi Arabia", 20000, "27/4/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Germany ", "Russia", 15000, "25/12/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Germany ", "Libya", 17000, "5/4/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Germany", "France", 30000, "3/1/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Germany ", "Spain", 14000, "8/2/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Germany ", "China", 16000, "4/3/2021", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Germany ", "Plestine", 18000, "7/1/2021", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("Germany ", "Morocco", 17000, "26/3/2021", R.drawable.ic_train_60,100);
        trips.add(t);




        //Train///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////##################################


        t=new Trip("Egypt", "Italy", 18000, "22/9/2023", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip(" Egypt ", "Russia", 25000, "5/11/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Egypt ", "Saudi Arabia", 15000, "17/9/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Egypt ", "Libya", 15000, "5/10/2023", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Egypt ", "France", 17000, "5/5/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Egypt", "Spain", 17000, "5/7/2023", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Egypt ", "China", 14000, "4/9/2023", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Egypt ", "Palestine", 16000, "27/4/2023", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("Egypt ", "Morocco", 18000, "31/11/2022", R.drawable.ic_train_60,150);
        trips.add(t);
        t=new Trip("Egypt ", "Germany", 17000, "30/4/2023", R.drawable.ic_train_60,110);
        trips.add(t);




        t=new Trip("Italy", "Egypt", 18000, "30/11/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Italy ", "Russia", 30000, "5/6/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip(" Italy ", "Saudi Arabia", 20000, "3/9/2023", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Italy ", "Libya", 18000, "5/7/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Italy ", "France", 17000, "4/10/2023", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Italy", "Spain", 30000, "16/7/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Italy ", "China", 35000, "25/9/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Italy ", "Palestine", 16000, "21/10/2022", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("Italy ", "Morocco", 18000, "28/11/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("Italy ", "Germany", 17000, "2/2/2023", R.drawable.ic_train_60,110);
        trips.add(t);



        t=new Trip("Russia", "Egypt", 40000, "30/10/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Russia ", "Italy", 30000, "5/8/2022", R.drawable.ic_train_60,151);
        trips.add(t);
        t=new Trip(" Russia ", "Saudi Arabia", 25000, "30/9/2023", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Russia ", "Libya", 30000, "9/11/2023", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Russia ", "France", 17000, "16/10/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Russia", "Spain", 30000, "23/11/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Russia ", "China", 25000, "30/12/2022", R.drawable.ic_train_60,110);
        trips.add(t);
        t=new Trip("Russia ", "Palestine", 27000, "13/10/2022", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("Russia ", "Morocco", 37000, "29/11/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("Russia ", "Germany", 36000, "25/9/2023", R.drawable.ic_train_60,110);
        trips.add(t);


        t=new Trip("Saudi Arabia", "Egypt", 18000, "4/4/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Saudi Arabia ", "Italy", 25000, "13/3/2022", R.drawable.ic_train_60,115);
        trips.add(t);
        t=new Trip(" Saudi Arabia ", "Russia", 20000, "28/2/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Libya", 18000, "31/3/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "France", 17000, "25/4/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Saudi Arabia", "Spain", 20000, "15/7/2022", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "China", 14000, "30/8/2023", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Palestine", 16000, "5/11/2023", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Morocco", 18000, "9/9/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("Saudi Arabia ", "Germany", 17000, "29/9/2022", R.drawable.ic_train_60,100);
        trips.add(t);


        t=new Trip("Libya", "Egypt", 18000, "31/9/2023", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Libya ", "Italy", 25000, "15/7/2022", R.drawable.ic_train_60,150);
        trips.add(t);
        t=new Trip(" Libya ", "Saudi Arabia", 20000, "30/1/2023", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Libya ", "Russia", 18000, "5/2/2023", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Libya ", "France", 17000, "5/6/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Libya", "Spain", 14000, "5/12/2022", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Libya ", "China", 30000, "4/9/2023", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Libya ", "Palestine", 16000, "5/10/2023", R.drawable.ic_train_60,112);
        trips.add(t);
        t=new Trip("Libya ", "Morocco", 18000, "5/3/2023", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("Libya ", "Germany", 17000, "7/9/2023", R.drawable.ic_train_60,100);
        trips.add(t);



        t=new Trip("France", "Egypt", 18000, "16/6/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" France ", "Italy", 25000, "23/7/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" France ", "Saudi Arabia", 20000, "27/1/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("France ", "Russia", 38000, "29/11/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("France ", "Libya", 17000, "14/5/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("France", "Spain", 30000, "26/8/2022", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("France ", "China", 34000, "13/9/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("France ", "Palestine", 16000, "27/10/2022", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("France ", "Morocco", 18000, "19/11/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("France ", "Germany", 17000, "17/9/2022", R.drawable.ic_train_60,100);
        trips.add(t);



        t=new Trip("Spain", "Egypt", 180000, "30/10/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Spain ", "Italy", 25000, "12/9/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Spain ", "Saudi Arabia", 20000, "9/2/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Spain ", "Russia", 25000, "7/1/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Spain ", "Libya", 17000, "5/11/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Spain", "France", 30000, "23/11/2022", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Spain ", "China", 25000, "3/11/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Spain ", "Palestine", 16000, "6/5/2022", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("Spain ", "Morocco", 18000, "5/1/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("Spain ", "Germany", 17000, "10/11/2022", R.drawable.ic_train_60,100);
        trips.add(t);


        t=new Trip("China", "Egypt", 25000, "23/2/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" China ", "Italy", 25000, "10/7/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" China ", "Saudi Arabia", 20000, "16/9/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("China ", "Russia", 18000, "15/12/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("China ", "Libya", 17000, "8/9/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("China", "France", 25000, "10/11/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("China ", "Spain", 30000, "26/9/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("China ", "Palestine", 16000, "21/10/2022", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("China ", "Morocco", 18000, "14/2/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("China ", "Germany", 17000, "18/9/2022", R.drawable.ic_train_60,100);
        trips.add(t);







        t=new Trip("Palestine", "Egypt", 15000, "12/6/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Palestine ", "Italy", 25000, "18/9/2022", R.drawable.ic_train_60,150);
        trips.add(t);
        t=new Trip(" Palestine ", "Saudi Arabia", 20000, "24/11/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Palestine ", "Russia", 18000, "17/12/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Palestine ", "Libya", 17000, "19/4/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Palestine", "France", 30000, "3/3/2022", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Palestine ", "Spain", 14000, "11/7/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Palestine ", "China", 16000, "21/5/2022", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("Palestine ", "Morocco", 18000, "11/11/2022", R.drawable.ic_train_60,115);
        trips.add(t);
        t=new Trip("Palestine ", "Germany", 17000, "21/9/2022", R.drawable.ic_train_60,100);
        trips.add(t);



        t=new Trip("Morocco", "Egypt", 18000, "3/9/2022", R.drawable.ic_train_60,150);
        trips.add(t);
        t=new Trip(" Morocco ", "Italy", 25000, "5/2/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Morocco ", "Saudi Arabia", 20000, "2/1/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Morocco ", "Russia", 18000, "4/8/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Morocco ", "Libya", 17000, "16/7/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Morocco", "France", 30000, "22/11/2022", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Morocco ", "Spain", 14000, "30/6/2022", R.drawable.ic_train_60,110);
        trips.add(t);
        t=new Trip("Morocco ", "China", 16000, "25/1/2021", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("Morocco ", "Plestine", 18000, "11/9/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("Morocco ", "Germany", 17000, "14/7/2022", R.drawable.ic_train_60,100);
        trips.add(t);



        t=new Trip("Germany", "Egypt", 18000, "16/6/2022", R.drawable.ic_train_60,150);
        trips.add(t);
        t=new Trip(" Germany ", "Italy", 25000, "24/10/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip(" Germany ", "Saudi Arabia", 20000, "27/4/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Germany ", "Russia", 15000, "25/12/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Germany ", "Libya", 17000, "5/4/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Germany", "France", 30000, "3/1/2022", R.drawable.ic_train_60,107);
        trips.add(t);
        t=new Trip("Germany ", "Spain", 14000, "8/2/2022", R.drawable.ic_train_60,100);
        trips.add(t);
        t=new Trip("Germany ", "China", 16000, "4/3/2022", R.drawable.ic_train_60,102);
        trips.add(t);
        t=new Trip("Germany ", "Plestine", 18000, "7/1/2022", R.drawable.ic_train_60,105);
        trips.add(t);
        t=new Trip("Germany ", "Morocco", 17000, "26/3/2022", R.drawable.ic_train_60,110);
        trips.add(t);


        //BUS/////////////////////////////////////////////////////////////////////////////////////////////////////////////*********************************************
        t=new Trip("Cairo", "Alexandria", 35, "30/9/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Cairo", "Luxor", 55, "1/10/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Cairo", "Aswan", 65, "2/10/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Cairo", "Fayoum", 15, "3/10/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Cairo", "Giza", 5, "4/10/2021", R.drawable.ic_bus_50,25);
        trips.add(t);


        t=new Trip("Alexandria", "Cairo", 35, "20/10/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Alexandria", "Luxor", 80, "21/10/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Alexandria", "Aswan", 90, "22/10/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Alexandria", "Fayoum", 40, "23/10/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Alexandria", "Giza", 30, "24/10/2021", R.drawable.ic_bus_50,25);
        trips.add(t);


        t=new Trip("Luxor", "Cairo", 55, "1/11/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Luxor", "Alexandria", 80, "2/11/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Luxor", "Aswan", 10, "3/11/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Luxor", "Fayoum", 44, "4/11/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Luxor", "Giza", 55, "5/11/2021", R.drawable.ic_bus_50,25);
        trips.add(t);


        t=new Trip("Aswan", "Cairo", 65, "20/11/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Aswan", "Alexandria", 90, "21/11/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Aswan", "Luxor", 10, "22/11/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Aswan", "Fayoum", 55, "23/11/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Aswan", "Giza", 65, "24/11/2021", R.drawable.ic_bus_50,25);
        trips.add(t);


        t=new Trip("Fayoum", "Cairo", 15, "1/12/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Fayoum", "Alexandria", 40, "2/12/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Fayoum", "Luxor", 44, "3/12/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Fayoum", "Aswan", 55, "4/12/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Fayoum", "Giza", 15, "5/12/2021", R.drawable.ic_bus_50,25);
        trips.add(t);


        t=new Trip("Giza", "Cairo", 5, "20/12/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Giza", "Alexandria", 30, "21/12/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Giza", "Luxor", 55, "22/12/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Giza", "Aswan", 65, "23/12/2021", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Giza", "Fayoum", 15, "24/12/2021", R.drawable.ic_bus_50,25);
        trips.add(t);


//////////////////////////////////////////////////////////////////////////////////////
// //////////////////////////////////////////////////////////////////////////////////


        t=new Trip("Cairo", "Alexandria", 35, "1/1/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Cairo", "Luxor", 55, "7/1/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Cairo", "Aswan", 65, "11/1/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Cairo", "Fayoum", 15, "23/1/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Cairo", "Giza", 5, "29/1/2022", R.drawable.ic_bus_50,25);
        trips.add(t);


        t=new Trip("Alexandria", "Cairo", 35, "1/3/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Alexandria", "Luxor", 80, "7/3/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Alexandria", "Aswan", 90, "11/3/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Alexandria", "Fayoum", 40, "23/3/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Alexandria", "Giza", 30, "29/3/2022", R.drawable.ic_bus_50,25);
        trips.add(t);


        t=new Trip("Luxor", "Cairo", 55, "1/5/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Luxor", "Alexandria", 80, "7/5/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Luxor", "Aswan", 10, "11/5/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Luxor", "Fayoum", 44, "23/5/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Luxor", "Giza", 55, "29/5/2022", R.drawable.ic_bus_50,25);
        trips.add(t);


        t=new Trip("Aswan", "Cairo", 65, "1/7/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Aswan", "Alexandria", 90, "11/7/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Aswan", "Luxor", 10, "17/7/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Aswan", "Fayoum", 55, "23/7/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Aswan", "Giza", 65, "29/7/2022", R.drawable.ic_bus_50,25);
        trips.add(t);


        t=new Trip("Fayoum", "Cairo", 15, "1/9/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Fayoum", "Alexandria", 40, "11/9/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Fayoum", "Luxor", 44, "17/9/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Fayoum", "Aswan", 55, "23/9/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Fayoum", "Giza", 15, "29/9/2022", R.drawable.ic_bus_50,25);
        trips.add(t);


        t=new Trip("Giza", "Cairo", 5, "1/11/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Giza", "Alexandria", 30, "11/11/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Giza", "Luxor", 55, "17/11/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Giza", "Aswan", 65, "23/11/2022", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Giza", "Fayoum", 15, "29/11/2022", R.drawable.ic_bus_50,25);
        trips.add(t);


///////////////////////////////////////////////////////////////////////////////////////////////////


        t=new Trip("Cairo", "Alexandria", 35, "2/2/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Cairo", "Luxor", 55, "10/2/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Cairo", "Aswan", 65, "18/2/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Cairo", "Fayoum", 15, "24/2/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Cairo", "Giza", 5, "28/2/2023",R.drawable.ic_bus_50,25);
        trips.add(t);


        t=new Trip("Alexandria", "Cairo", 35, "2/4/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Alexandria", "Luxor", 80, "10/4/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Alexandria", "Aswan", 90, "18/4/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Alexandria", "Fayoum", 40, "24/4/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Alexandria", "Giza", 30, "28/4/2023", R.drawable.ic_bus_50,25);
        trips.add(t);


        t=new Trip("Luxor", "Cairo", 55, "2/6/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Luxor", "Alexandria", 80, "10/6/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Luxor", "Aswan", 10, "18/6/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Luxor", "Fayoum", 44, "24/6/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Luxor", "Giza", 55, "28/6/2023", R.drawable.ic_bus_50,25);
        trips.add(t);


        t=new Trip("Aswan", "Cairo", 65, "2/8/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Aswan", "Alexandria", 90, "10/8/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Aswan", "Luxor", 10, "18/8/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Aswan", "Fayoum", 55, "24/8/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Aswan", "Giza", 65, "28/8/2023", R.drawable.ic_bus_50,25);
        trips.add(t);


        t=new Trip("Fayoum", "Cairo", 15, "2/10/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Fayoum", "Alexandria", 40, "10/10/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Fayoum", "Luxor", 44,"18/10/2023" , R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Fayoum", "Aswan", 55, "24/10/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Fayoum", "Giza", 15, "28/10/2023", R.drawable.ic_bus_50,25);
        trips.add(t);

        t=new Trip("Giza", "Cairo", 5, "2/12/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Giza", "Alexandria", 30, "10/12/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Giza", "Luxor", 55, "18/12/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Giza", "Aswan", 65, "24/12/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        t=new Trip("Giza", "Fayoum", 15, "28/12/2023", R.drawable.ic_bus_50,25);
        trips.add(t);
        for(int i = 0; i < trips.size();i++) {
            DocumentReference mydef = FirebaseFirestore.getInstance().document("sampledata/trips");
            Map<String, Object> tripdata = new HashMap<>();
            tripdata.put("From", trips.get(i).from);
            tripdata.put("TO", trips.get(i).to);
            tripdata.put("price", trips.get(i).price);
            tripdata.put("Quantity", trips.get(i).quantity);
            tripdata.put("Date", trips.get(i).time);
            tripdata.put("Photo", trips.get(i).photo);
// Add a new document with a generated ID
            mydef.collection("trips")
                    .add(tripdata)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error adding document", e);
                        }
                    });
        }*/
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