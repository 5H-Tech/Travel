package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SignIn extends AppCompatActivity {
    public static String s ;
    private String s_email;
    private String s_pass;
    boolean isShow =true;
    public static ArrayList<User> users= new ArrayList<User>() ;
    User a = new User("a","a","a","a");
    //declaration
    TextView textView;
    public TextView create;
    public Button signin;
    public Button show ;
    public EditText pass;
    public EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        users.add(a);
        //textView = findViewById(R.id.massres);
        create = findViewById(R.id.create);
        signin = findViewById(R.id.signIn_btn);
        show = findViewById(R.id.show_btn);
        pass = findViewById(R.id.pass_up);
        email = findViewById(R.id.name_input);

        //show and hid the password
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp.showPassword(pass);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = signin();
                if (index == -1)
                {
                    Toast.makeText(v.getContext(),"USER NO FOUND", Toast.LENGTH_SHORT).show();
                }
                else{
                    s= new String("willcome mr :"+ users.get(index).getS_name()) ;

                }


            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my = new Intent(v.getContext(),SignUp.class);
                startActivityForResult(my, 0);
                Toast.makeText(v.getContext(),"hi",Toast.LENGTH_SHORT).show();
            }
        });


    }
    private int signin (){
        s_email = new String(String.valueOf(email.getText()));
        s_pass= new String(String.valueOf(pass.getText()) );
        boolean found = false ;
        for (int i = 0 ; i<users.size(); i++){
            if (users.get(i).getS_email().equals(s_email)  && users.get(i).getS_pass().equals(s_pass) ){
                return i;
            }
        }
        return -1;
    }
}

/*

public class MainActivity extends AppCompatActivity {
    public static String s ;
    private String s_email;
    private String s_pass;
    boolean isShow =true;
    public static ArrayList<User> users= new ArrayList<User>() ;
    User a = new User("a","a","a","a");
    //declaration
     TextView textView;
    public TextView create;
    public Button signin;
    public Button show ;
    public EditText pass;
    public EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users.add(a);
       textView = findViewById(R.id.massres);
       create = findViewById(R.id.create);
       signin = findViewById(R.id.signIn_btn);
       show = findViewById(R.id.show_btn);
       pass = findViewById(R.id.pass_up);
       email = findViewById(R.id.name_input);

        //show and hid the password
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp.showPassword(pass);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = signin();
                if (index == -1)
                {
                    Toast.makeText(v.getContext(),"USER NO FOUND",Toast.LENGTH_SHORT).show();
                }
                else{
                    s= new String("willcome mr :"+ users.get(index).getS_name()) ;

                }


            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my = new Intent(v.getContext(),SignUp.class);
                startActivityForResult(my, 0);
                Toast.makeText(v.getContext(),"hi",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private int signin (){
        s_email = new String(String.valueOf(email.getText()));
        s_pass= new String(String.valueOf(pass.getText()) );
        boolean found = false ;
        for (int i = 0 ; i<users.size(); i++){
            if (users.get(i).getS_email().equals(s_email)  && users.get(i).getS_pass().equals(s_pass) ){
                return i;
            }
        }
        return -1;
    }

}
 */