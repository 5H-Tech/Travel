package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Destination extends AppCompatActivity {
    public String s_from;
    public String s_to;
    EditText t_from ;
    EditText t_to;
    public static List<Trip>currenttripList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);



        Button btn_mytrip = findViewById(R.id.btn_MyTrip);
        Button btn_alltrips = findViewById(R.id.btn_AllTrips);

        btn_mytrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Trip>tripList=new ArrayList<>();
                tripList.clear();
                String From,To;
                final Spinner from_spinn = (Spinner)findViewById(R.id.spinner_From);
                final Spinner to_spinn = (Spinner)findViewById(R.id.spinner_To);

                From =from_spinn.getSelectedItem().toString();
                To =to_spinn.getSelectedItem().toString();
//                Intent val_of_from = new Intent(Destination.this,Home.class);
//                val_of_from.putExtra("From",From);
//                Intent val_of_to = new Intent(Destination.this,Home.class);
//                val_of_to.putExtra("To",To);
               // Toast.makeText(Destination.this, "(CharSequence)" +From,Toast.LENGTH_LONG).show();
                for (int i=0;i<currenttripList.size();i++)
                {
                    if ((currenttripList.get(i).from.equals(" "+From)||currenttripList.get(i).from.equals(From)
                            ||currenttripList.get(i).from.equals(From+" ")||currenttripList.get(i).from.equals(" "+From+" "))&&
                            (currenttripList.get(i).to.equals(" "+To)||currenttripList.get(i).to.equals(To)||
                                    currenttripList.get(i).to.equals(To+" ")||currenttripList.get(i).to.equals(" "+To+" ")))
                    {
                        tripList.add(currenttripList.get(i));
                    }
                    /*boolean found = currenttripList.get(i).from.matches(From) && currenttripList.get(i).to.matches(To);
                    if(found)
                    {
                        tripList.add(currenttripList.get(i));
                    }*/
                }
                if(! tripList.isEmpty()){
                    Show_travilsActivity.Destination=tripList;
                    Intent i = new Intent(Destination.this, Show_travilsActivity.class);
                    startActivity(i);
                }
                else Toast.makeText(getApplicationContext(),"This Trip is not Available Now",Toast.LENGTH_SHORT).show();

            }

        });

        btn_alltrips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Show_travilsActivity.Destination=currenttripList;
                Intent i = new Intent(Destination.this, Show_travilsActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        MenuInflater inflater=getMenuInflater();
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