package com.example.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class Add_Trip_Activity extends AppCompatActivity {
    Spinner frSpinner,toSpinner,catSpinner;
    EditText price, quantity, date;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);
        frSpinner=findViewById(R.id.spinner_From);
        toSpinner=findViewById(R.id.spinner_To);
      //  catSpinner=findViewById(R.id.spinner_cat);
        price=findViewById(R.id.textprice);
        quantity=findViewById(R.id.textquantityid);
        date=findViewById(R.id.textdate);
        add=findViewById(R.id.addbtnid);


        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String from = frSpinner.getSelectedItem().toString();
                String to = toSpinner.getSelectedItem().toString();
                String cat = catSpinner.getSelectedItem().toString();
                int s_price = Integer.parseInt(price.getText().toString());
                int s_quantity = Integer.parseInt(quantity.getText().toString());
                int s_date = Integer.parseInt(date.getText().toString());
                int photo_id;
                /*if (cat.equals("Bus"))
                    photo_id=R.drawable.ic_bus_50;
                else if(cat.equals("Plane"))
                    photo_id= R.drawable.ic_airplane_24dp;
                else
                    photo_id= R.drawable.ic_train_60;*/



                DocumentReference mydef = FirebaseFirestore.getInstance().document("sampledata/trips");
                Map<String, Object> tripdata = new HashMap<>();
                tripdata.put("From", from);
                tripdata.put("TO", to);
                tripdata.put("price", s_price);
                tripdata.put("Quantity", s_quantity);
                tripdata.put("Date", s_date);
                tripdata.put("Photo", R.drawable.ic_airplane_24dp);
// Add a new document with a generated ID
                mydef.collection("trips")
                        .add(tripdata)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(getApplicationContext(),"sucss",Toast.LENGTH_SHORT).show();
                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {

                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });

            }


        });

    }



}
