package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
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