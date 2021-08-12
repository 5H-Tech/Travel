package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SignUp extends AppCompatActivity {
    //public static ArrayList<User> users= new ArrayList<User>() ;
    private String s_name ,
            s_email,
            s_phone,
            s_pass;
    EditText t_name,
            t_emil ,
            t_phone ,
            t_pass ,
            t_cpass ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        t_name= findViewById(R.id.name_input);
        t_emil = findViewById(R.id.email_upup);
        t_phone = findViewById(R.id.phone_input);
        t_pass = findViewById(R.id.pass_up);
        t_cpass = findViewById(R.id.c_pass_up);

        Button btn_show1 = findViewById(R.id.show1_up),
                btn_show2= findViewById(R.id.show2_up),
                btn_signup = findViewById(R.id.signup_btn);

        btn_show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPassword(t_pass);
            }
        });
        btn_show2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPassword(t_cpass);
            }
        });
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (signup())
                {
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivityForResult(intent, 0);
                }

            }
        });


    }

    private boolean signup(){
        s_name = new String(String.valueOf(t_name.getText()));
        s_email = new String(String.valueOf(t_emil.getText()));
        s_phone = new String(String.valueOf(t_phone.getText()));
        s_pass = new String(String.valueOf(t_pass.getText()));


        if (s_pass.isEmpty() || s_name.isEmpty()||s_email.isEmpty()||s_phone.isEmpty())
        {
            Toast.makeText(this,"You must fill all filds ... try again " ,Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            User temp = new User(s_name,s_email,s_phone,s_pass);
            SignIn.users.add(temp);
            Toast.makeText(this,"you have registered successful",Toast.LENGTH_SHORT).show();
            return true;
        }

    }

    public static boolean isShow = true;
    public static void showPassword (EditText pass){

        if (isShow){
            pass.setTransformationMethod(null);
            isShow = false;
        }
        else
        {
            pass.setTransformationMethod(new PasswordTransformationMethod());
            isShow = true;
        }
    }

}