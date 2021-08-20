package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

import static android.content.ContentValues.TAG;

public class Profile extends AppCompatActivity implements View.OnClickListener{
    EditText  name, phone, email;
    Button bhome,save;
    StorageReference mStorageRef;
    FirebaseUser user;
    ImageView pro_image;
    String profileimageurl;
    static String current_profile_image;
    static final int chose_image =101;
    Uri image_uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        user = SignIn.mAuth.getCurrentUser();

        save=findViewById(R.id.saveprofilebtnid);
        save.setOnClickListener(this);
        pro_image=findViewById(R.id.profileimageid);
        if (user.getPhotoUrl()!=null)
        {
            Glide.with(this)
                    .load(user.getPhotoUrl())
                    .into(pro_image);
            current_profile_image =user.getPhotoUrl().toString();
        }
        pro_image.setOnClickListener(this);
        name=findViewById(R.id.name_porfile);
        phone=findViewById(R.id.phone_porifle);
        email=findViewById(R.id.email_porfile);
        bhome=findViewById(R.id.home_btn);
        bhome.setOnClickListener((View.OnClickListener) this);
        email.setText(user.getEmail().toString());
        DocumentReference mydef = FirebaseFirestore.getInstance().document("sampledata/users");
        mydef.collection("data")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if (user.getUid().equals(document.getString("id")))
                                {
                                    name.setText(document.getString("name"));
                                    phone.setText(document.getString("phone"));
                                    break;
                                }
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==chose_image &&resultCode==RESULT_OK &&data!=null&&data.getData()!=null)
        {
            image_uri=data.getData();
            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),image_uri);
                pro_image.setImageBitmap(bitmap);
                uploadphoto();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void show_images()
    {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent.createChooser(intent, "select product photo"), chose_image) ;
    }

    void updateuserinformation()
    {
            if (user!=null&&profileimageurl!=null)
            {
                UserProfileChangeRequest profile=new UserProfileChangeRequest.Builder()
                        .setPhotoUri(Uri.parse( profileimageurl))
                        .build()
                        ;
                user.updateProfile(profile).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getApplicationContext(), "User information has been updated successfully", Toast.LENGTH_LONG).show();
                    }
                });
            }
    }

    void uploadphoto()
    {
        StorageReference mStorageRef = FirebaseStorage.getInstance().getReference("profilepics/" + System.currentTimeMillis() + ".jpg");
        if (image_uri!=null)
        {
            mStorageRef.putFile(image_uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getApplicationContext(), "Photo has been uploaded successfully", Toast.LENGTH_LONG).show();
               // profileimageurl = taskSnapshot.getMetadata().getReference().getDownloadUrl().toString();
                    taskSnapshot.getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                                profileimageurl=uri.toString();
                        }
                    });
            }
        }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

        }

    }


    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.home_btn)
        {
            Intent intent = new Intent(getApplicationContext(), Home.class);
            startActivity(intent);
        }
        else if (view.getId()==R.id.profileimageid)
        {
            show_images();

        }
        else if (view.getId()==R.id.saveprofilebtnid)
        {
            updateuserinformation();
        }
    }
}