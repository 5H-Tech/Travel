package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
    static int count_of_tickets;

    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_details);

        ImageView transport_view = (ImageView)findViewById(R.id.Transport_id);
        TextView from_txt = (TextView)findViewById(R.id.tv_from);
        TextView to_txt = (TextView)findViewById(R.id.tv_to);
        TextView price_txt = (TextView)findViewById(R.id.tv_price);
        TextView quan=findViewById(R.id.textavlqtyid);
        TextView time_txt = (TextView)findViewById(R.id.tv_time);
        ImageView add = (ImageView) findViewById(R.id.img_add);
        ImageView remove= (ImageView) findViewById(R.id.img_remove);
        count = (EditText) findViewById(R.id.tec_count);
        confirm = (Button)findViewById(R.id.confirm_btn);
        count_of_tickets=0;





        Trip t = new Trip();
        if(Home.is_bus){
            transport_view.setImageResource(R.drawable.ic_bus_50);
            photo=R.drawable.ic_bus_50;
        }
        else if(Home.is_air){
            transport_view.setImageResource(R.drawable.ic_airplane_24dp);
            photo=R.drawable.ic_airplane_24dp;
        }
        else if(Home.is_train){
            transport_view.setImageResource(R.drawable.ic_train_60);
            photo=R.drawable.ic_train_60;
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
                count.setText(String.valueOf(Integer.valueOf(count.getText().toString()) + 1));
                count_of_tickets+=1;
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.valueOf(count.getText().toString()) - 1 <= 0){
                    count.setText(String.valueOf(0));
                    Toast.makeText(v.getContext(),"You can't remove",Toast.LENGTH_SHORT).show();
                }
                else{
                    count.setText(String.valueOf(Integer.valueOf(count.getText().toString()) - 1));
                    count_of_tickets-=1;
                }


            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm_booking(v.getContext());
                Receipt r=new Receipt();
                Intent receipt_intent=new Intent(getApplication(),Receipt.class);
                startActivity(receipt_intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

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

    public static void confirm_booking(Context context){
        FirebaseUser user =SignIn.mAuth.getCurrentUser();
        DocumentReference gettcartdef = FirebaseFirestore.getInstance().document("sampledata/trips");
        gettcartdef.collection("trips")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        boolean found=false;
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if (document.getId().equals(id))
                                {
                                    found=true;
                                    DocumentReference tripdef = FirebaseFirestore.getInstance().collection("sampledata").document("trips")
                                            .collection("trips").document(document.getId());
                                    Map<String, Object> tcart = new HashMap<>();
                                    tcart.put("Quantity",Integer.valueOf(document.get("Quantity").toString())-Integer.valueOf(count.getText().toString()));
                                    if (Integer.valueOf(count.getText().toString())>Integer.valueOf(document.get("Quantity").toString()))
                                    {
                                        Toast.makeText(context, "Sorry there is no available tickets", Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        tripdef.update(tcart);

                                    if(count.getText().toString().equals("0"))
                                        Toast.makeText(context, "Please Enter correct number", Toast.LENGTH_SHORT).show();
                                    else {
                                        Intent intent = new Intent(context,Receipt.class);
                                        Toast.makeText(context, "Your ticket has been added", Toast.LENGTH_SHORT).show();
                                        add_to_bookied_list(context, from, to, price, Integer.valueOf(count.getText().toString()), time, photo);
                                        Receipt.ticket_quantity=count_of_tickets;
                                    }
                                    }

                                    break;
                                }

                            }

                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }

                    }
                });
    }

    public static void add_to_bookied_list(Context context, String from, String to, int s_price, int s_quantity, String s_date, int photo_id)
    {
        DocumentReference mydef = FirebaseFirestore.getInstance().document("sampledata/booked");
        Map<String, Object> tripdata = new HashMap<>();
        tripdata.put("userid", SignIn.mAuth.getUid());
        tripdata.put("From", from);
        tripdata.put("TO", to);
        tripdata.put("price", s_price);
        tripdata.put("Quantity", s_quantity);
        tripdata.put("Date", s_date);
        tripdata.put("Photo", photo_id);
// Add a new document with a generated ID
        mydef.collection("data")
                .add(tripdata)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(context,"Trip has been added successfully",Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());

                    }
                })
                .addOnFailureListener(new OnFailureListener() {

                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                        Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
    }
}