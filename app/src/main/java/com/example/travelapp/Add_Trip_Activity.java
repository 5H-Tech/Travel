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
        frSpinner=findViewById(R.id.spinner_cat);
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
                int s_price = Integer.valueOf(price.getText().toString());
                int s_quantity = Integer.valueOf(quantity.getText().toString());
                int s_date = Integer.valueOf(date.getText().toString());
                if (price.getText().equals("") || quantity.getText().equals("") || date.getText().equals("")) {
                    Toast.makeText(getApplicationContext(), "please enter all data", Toast.LENGTH_LONG).show();
                }
                else
                {
                DocumentReference mydef = FirebaseFirestore.getInstance().document("sampledata/trips");
                Map<String, Object> tripdata = new HashMap<>();
                tripdata.put("From", from);
                tripdata.put("TO", to);
                tripdata.put("price", s_price);
                tripdata.put("Quantity", s_quantity);
                tripdata.put("Date", s_date);
                tripdata.put("Photo", cat);
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

            }

            }
        });

    }



}
