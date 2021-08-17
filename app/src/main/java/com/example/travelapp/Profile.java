package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import static android.content.ContentValues.TAG;

public class Profile extends AppCompatActivity implements View.OnClickListener{
    EditText  name, phone, email;
    Button bhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        FirebaseUser user = SignIn.mAuth.getCurrentUser();

        name=findViewById(R.id.name_porfile);
        phone=findViewById(R.id.phone_porifle);
        email=findViewById(R.id.email_porfile);
        bhome=findViewById(R.id.home_btn);
        bhome.setOnClickListener((View.OnClickListener) this);
        email.setText(user.getEmail().toString());
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
                                    name.setText(document.getString("name"));
                                    phone.setText(document.getString("phone"));
                                    break;
                                }
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.home_btn)
        {
            Intent intent = new Intent(getApplicationContext(), Home.class);
            startActivity(intent);
        }
    }
}