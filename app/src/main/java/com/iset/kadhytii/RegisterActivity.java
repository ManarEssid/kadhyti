package com.iset.kadhytii;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class RegisterActivity extends AppCompatActivity {
    EditText editTextName , editTextEmail,editTextMobile,editTextPassword;
    Button cirRegisterButton;
    TextView registerlog;


   DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://kadhytii-default-rtdb.firebaseio.com/");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        changeStatusBarColor();

        editTextName  = findViewById(R.id.editTextName);
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextMobile=findViewById(R.id.editTextMobile);
        editTextPassword=findViewById(R.id.editTextPassword);
        cirRegisterButton=findViewById(R.id.cirRegisterButton);
        registerlog=findViewById(R.id.registerlog);
        cirRegisterButton=findViewById(R.id.cirRegisterButton);
        cirRegisterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){




                final String Name= editTextName.getText().toString();
                final String Email= editTextEmail.getText().toString();
                final String MobileNumber= editTextMobile.getText().toString();
                final  String password= editTextPassword.getText().toString();
                   if(Name.isEmpty() || Email.isEmpty() || MobileNumber.isEmpty() || password.isEmpty()){
                       Toast.makeText(RegisterActivity.this,"Please fill all fields ", Toast.LENGTH_SHORT).show();

                   }
                   else {

                       databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                           @Override
                           public void onDataChange(@NonNull DataSnapshot snapshot) {
                               if(snapshot.hasChild(MobileNumber)){
                                   Toast.makeText(RegisterActivity.this,"This Phone is already registred ", Toast.LENGTH_SHORT).show();

                               }
                               else{
                                   databaseReference.child("users").child(MobileNumber).child("Name").setValue(Name);
                                   databaseReference.child("users").child(MobileNumber).child("Email").setValue(Email);
                                   databaseReference.child("users").child(MobileNumber).child("password").setValue(password);
                                   //Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                   //intent.putExtra("Name", Name);
                                   Toast.makeText(RegisterActivity.this,"User Registred sucessfully ", Toast.LENGTH_SHORT).show();
                                   finish();

                               }

                           }

                           @Override
                           public void onCancelled(@NonNull DatabaseError error) {

                           }
                       });

                   }



            }
        });

    }
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));
        }
    }

    public void onLoginClick(View view){
        startActivity(new Intent(this, LoginActivity.class));
        overridePendingTransition(R.anim.slide_in_left,android.R.anim.slide_out_right);

    }



}
