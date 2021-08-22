package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class About extends AppCompatActivity {

    TextView github,ehab,haytham,ahmed,atef,fares,eman ;
    Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        github= findViewById(R.id.github_about_tv);
        ahmed=findViewById(R.id.textView18);
        atef=findViewById(R.id.textView19);
        ehab=findViewById(R.id.textView20);
        haytham=findViewById(R.id.textView21);
        fares=findViewById(R.id.textView22);
        eman=findViewById(R.id.textView23);
        home = findViewById(R.id.about_home_btn);


        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/HadyAhmed00/Travel"));
                startActivity(browserIntent);
            }
        });

        ahmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent H_Ahmed_Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/HadyAhmed00"));
                startActivity(H_Ahmed_Intent);
            }
        });
        atef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent H_Atef_Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/hady-o"));
                startActivity(H_Atef_Intent);
            }
        });

        ehab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent H_Ehab_Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/HodBossHod"));
                startActivity(H_Ehab_Intent);
            }
        });

        haytham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Haytham_Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/haitham2001"));
                startActivity(Haytham_Intent);
            }
        });

        fares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Fares_Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Fares3993"));
                startActivity(Fares_Intent);
            }
        });

        eman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Eman_Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Eman525"));
                startActivity(Eman_Intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), Home.class);
                startActivity(intent);
            }
        });
    }
}