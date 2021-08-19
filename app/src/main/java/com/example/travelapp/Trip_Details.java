package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class Trip_Details extends AppCompatActivity {
    static String from, to, time,id;
    static int photo,price,avl_qty;
    public static EditText count;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_details);
        user =SignIn.mAuth.getCurrentUser();
        ImageView transport_view = (ImageView)findViewById(R.id.Transport_id);
        TextView from_txt = (TextView)findViewById(R.id.tv_from);
        TextView to_txt = (TextView)findViewById(R.id.tv_to);
        TextView price_txt = (TextView)findViewById(R.id.tv_price);
        TextView quan=findViewById(R.id.textavlqtyid);
        TextView time_txt = (TextView)findViewById(R.id.tv_time);
        ImageView add = (ImageView) findViewById(R.id.img_add);
        ImageView remove= (ImageView) findViewById(R.id.img_remove);
        count = (EditText) findViewById(R.id.tec_count);


        Trip t = new Trip();
        if(Home.is_bus){
            transport_view.setImageResource(R.drawable.ic_bus_50);
        }
        else if(Home.is_air){
            transport_view.setImageResource(R.drawable.ic_airplane_24dp);
        }
        else if(Home.is_train){
            transport_view.setImageResource(R.drawable.ic_train_60);
        }
        else if(Home.is_ticket){
            transport_view.setImageResource(R.drawable.ic_ticket_50);
        }

        from_txt.setText(from);
        to_txt.setText(to);
        price_txt.setText(String.valueOf(price));
        time_txt.setText(time);
        quan.setText(String.valueOf(avl_qty));

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DocumentReference gettcartdef = FirebaseFirestore.getInstance().document("sampledata/carts");
                gettcartdef.collection("cartdata")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                boolean found=false;
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        if (document.getString("tripid").equals(id)&&document.getString("userid").equals(user.getUid()))
                                        {
                                            found=true;
                                            DocumentReference cartdef = FirebaseFirestore.getInstance().collection("sampledata").document("carts")
                                                    .collection("cartdata").document(document.getId());
                                            Map<String, Object> cart = new HashMap<>();
                                            cart.put("quantity",Integer.valueOf(document.get("quantity").toString())+1);
                                            count.setText(String.valueOf(Integer.valueOf(document.get("quantity").toString())+1));

                                            cartdef.update(cart);

                                            break;
                                        }

                                    }
                                    if (found==false)
                                    {
                                        DocumentReference cartdef = FirebaseFirestore.getInstance().document("sampledata/carts");
                                        Map<String, Object> cart = new HashMap<>();
                                        cart.put("userid", user.getUid());
                                        cart.put("tripid",id);
                                        cart.put("quantity",1);
                                        cartdef.collection("cartdata")
                                                .add(cart)
                                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                                    @Override
                                                    public void onSuccess(DocumentReference documentReference) {
                                                        count.setText(String.valueOf(1));
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
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                }

                            }
                        });



            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DocumentReference gettcartdef = FirebaseFirestore.getInstance().document("sampledata/carts");
                gettcartdef.collection("cartdata")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                boolean found=false;
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        if (document.getString("tripid").equals(id)&&document.getString("userid").equals(user.getUid()))
                                        {
                                            found=true;
                                            DocumentReference cartdef = FirebaseFirestore.getInstance().collection("sampledata").document("carts")
                                                    .collection("cartdata").document(document.getId());
                                            Map<String, Object> cart = new HashMap<>();
                                            cart.put("quantity",Integer.valueOf(document.get("quantity").toString())-1);
                                            count.setText(String.valueOf(Integer.valueOf(document.get("quantity").toString())-1));
                                            cartdef.update(cart);

                                            if (Integer.valueOf(document.get("quantity").toString())<=0)
                                            {
                                                cartdef.delete();
                                            }
                                            break;
                                        }

                                    }
                                    if (found==false)
                                    {
                                        Toast.makeText(getApplicationContext(), "you cant remove this trip", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                }

                            }
                        });





            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent intent=new Intent(getApplication(),Profile.class);
                startActivity(intent);
                return true;
            case R.id.item2:
                Intent intent1=new Intent(getApplication(),About.class);
                startActivity(intent1);
                return true;
            case R.id.item3:
                Intent intentt=new Intent(getApplication(),MainActivity.class);
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(intentt);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}