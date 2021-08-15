package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class SignUp extends AppCompatActivity {
    boolean up=false;
    public static FirebaseAuth mAuth;
    private StorageReference mStorageRef;
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
    TextView sing_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        mStorageRef = FirebaseStorage.getInstance().getReference();
        t_name= findViewById(R.id.name_input);
        t_emil = findViewById(R.id.email_upup);
        t_phone = findViewById(R.id.phone_input);
        t_pass = findViewById(R.id.pass_up);
        t_cpass = findViewById(R.id.c_pass_up);
        sing_in =findViewById(R.id.tv_singin);

        Button btn_show1 = findViewById(R.id.show1_up),
                btn_show2= findViewById(R.id.show2_up),
                btn_signup = findViewById(R.id.signup_btn);

        //show pass
        btn_show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPassword(t_pass);
            }
        });
        //show conform
        btn_show2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPassword(t_cpass);
            }
        });
        //main button
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< Updated upstream
              if (signup())
              {
                  Toast.makeText(v.getContext(), "you have registered successfully", Toast.LENGTH_LONG).show();
                  Intent intent = new Intent(v.getContext(), MainActivity.class);
                  startActivityForResult(intent, 0);
              }
            }
        });
=======
               signup();



>>>>>>> Stashed changes

        //sign in tv
        sing_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SignIn.class);
                startActivity(intent);
            }
        });


    }

    private boolean signup() {

                String name = t_name.getText().toString();
                String email = t_emil.getText().toString().trim();
                String phone = t_phone.getText().toString();
                String pass = t_pass.getText().toString().trim();
                String s_cpass = t_cpass.getText().toString();

        if (pass.isEmpty() || name.isEmpty() || email.isEmpty() || phone.isEmpty() || s_cpass.isEmpty()) {
            Toast.makeText(this, "You must fill all filds ... try again ", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!pass.equals(s_cpass)) {
            Toast.makeText(this, "your confirmation password is incorrect", Toast.LENGTH_LONG).show();
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            t_emil.setError("Eamil is invalid");
            t_emil.requestFocus();
            return false;
        }

        else {

            mAuth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                // Sign in success, update UI with the signed-in user's information
                                up=true;
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                if(user!=null)
                                {
                                    DocumentReference mydef = FirebaseFirestore.getInstance().document("sampledata/users");
                                    Map<String, Object> userdata = new HashMap<>();
                                    userdata.put("name", name);
                                    userdata.put("id",user.getUid());
                                    userdata.put("phone",phone);


// Add a new document with a generated ID
                                    mydef.collection("data")
                                            .add(userdata)
                                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                                @Override
                                                public void onSuccess(DocumentReference documentReference) {
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
                                Toast.makeText(getApplication(), "Registeration succesfully", Toast.LENGTH_LONG).show();

                                Intent intent = new Intent(getApplicationContext(),EmailverifiyActivity.class);
                                startActivity(intent);

                            }
                            else if (task.getException() instanceof FirebaseAuthUserCollisionException)
                            {
                                Toast.makeText(getApplication(), "this Email is already exist", Toast.LENGTH_LONG).show();
                            }
                            else {
                                // If sign in fails, display a message to the user.
                                up=false;
                                Toast.makeText(getApplication(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            }// ...
                        }
                    });





           return up;
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