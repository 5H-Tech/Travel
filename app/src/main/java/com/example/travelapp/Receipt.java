package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import static android.content.ContentValues.TAG;

public class Receipt extends AppCompatActivity {
    static int ticket_quantity;
    Button home_btn;
    FirebaseUser user;
    TextView user_name,price,tickets_quantity,total_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        user=SignIn.mAuth.getCurrentUser();
        user_name=findViewById(R.id.tv_name_receipt);
        price=findViewById(R.id.tv_price_item_receipt);
        price.setText(String.valueOf(Trip_Details.price));
        tickets_quantity=findViewById(R.id.avl_qun_receipt);
        tickets_quantity.setText(String.valueOf(ticket_quantity));
        total_price=findViewById(R.id.tv_total_parice_receipt);
        total_price.setText(String.valueOf(Trip_Details.price*ticket_quantity));
        DocumentReference mydef = FirebaseFirestore.getInstance().document("sampledata/users");
        mydef.collection("data")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if (user.getUid().equals(document.getString("id")))
                                {
                                    user_name.setText(document.getString("name"));
                                    break;
                                }
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });

        home_btn=(Button)findViewById(R.id.home_receipt);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), Home.class);
                startActivity(intent);
            }
        });
    }



}