package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class SignIn extends AppCompatActivity {
    public static String s ;
    private String s_email;
    private String s_pass;
    boolean isShow =true;
    private FirebaseAuth mAuth;
    public static ArrayList<User> users= new ArrayList<User>() ;

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
        mAuth = FirebaseAuth.getInstance();

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
                    signin();
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
    private void signin (){
        s_email = new String(String.valueOf(email.getText()));
        s_pass= new String(String.valueOf(pass.getText()) );
        boolean found = false ;
<<<<<<< Updated upstream
        if(s_email.isEmpty()||s_pass.isEmpty())
        {
            Toast.makeText(this,"Pleas enter you information to sign in",Toast.LENGTH_SHORT).show();
        }
        else{
            mAuth.signInWithEmailAndPassword(s_email, s_pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent =new Intent(getApplicationContext(),Home.class);
                                startActivity(intent);

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(getApplication(), "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }

=======
        mAuth.signInWithEmailAndPassword(s_email, s_pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user.isEmailVerified()) {
                                Intent intent = new Intent(getApplicationContext(), Home.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(getApplication(), "your Email is not verified", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(getApplication(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
>>>>>>> Stashed changes

                        }
                    });
        }

    }
}
