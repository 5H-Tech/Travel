package com.example.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;
import static com.example.travelapp.Receipt.ticket_quantity;

public class Show_travilsActivity extends AppCompatActivity {

    RecyclerView travilsview;
    Adpter travilsAdpter;
    static List<Trip>Destination=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_travils);

        travilsview=findViewById(R.id.recyclerview);
        travilsAdpter = new Adpter(Destination);
        RecyclerView.LayoutManager mylayoutmanager = new LinearLayoutManager(getApplicationContext());
        travilsview.setLayoutManager(mylayoutmanager);
        travilsview.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        travilsview.setAdapter(travilsAdpter);
        travilsview.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), travilsview, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if(!Home.is_ticket)
                {
                    Intent i = new Intent(Show_travilsActivity.this, Trip_Details.class);
                    Trip t = Destination.get(position);
                    Trip_Details.from = t.getFrom();
                    Trip_Details.to = t.getTo();
                    Trip_Details.price = t.getPrice();
                    Trip_Details.time = t.getTime();
                    Trip_Details.id = t.id;
                    Trip_Details.avl_qty = t.quantity;
                    startActivity(i);
                }
            }

            @Override
            public void onLongClick(View view, int position) {
                Trip t = Destination.get(position);
                if (SignIn.isAdmin==true) {


                    DocumentReference deletedef = FirebaseFirestore.getInstance().collection("sampledata").document("trips")
                            .collection("trips").document(t.id);
                   deletedef.delete();
                   Toast.makeText(getApplicationContext(), "Trip has been deleted", Toast.LENGTH_LONG).show();
                   finish();
                   Intent in=new Intent(getApplicationContext(),Show_travilsActivity.class);
                    startActivity(in);


                }
            }
        }));

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(!SignIn.isAdmin)
        {
            MenuInflater inflater =getMenuInflater();
            inflater.inflate(R.menu.menu1,menu);
            return true;
        }
       return false;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(!SignIn.isAdmin)
        {
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
        }
        return super.onOptionsItemSelected(item);
    }
}
