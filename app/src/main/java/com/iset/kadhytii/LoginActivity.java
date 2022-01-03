package com.iset.kadhytii;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {

EditText editTextEmail,editTextPassword;
    Button cirLoginButton;
    TextView textv,register,methode;
    ImageView image1,face,google,plus;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


         editTextEmail  = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        cirLoginButton=findViewById(R.id.cirLoginButton);
        textv= findViewById(R.id.textv);
        image1= findViewById(R.id.image1);
        register= findViewById(R.id.register);
        face= findViewById(R.id.face);
        methode= findViewById(R.id.methode);
        google= findViewById(R.id.google);
        plus = findViewById(R.id.plus);

        cirLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email= editTextEmail.getText().toString();
                final String password= editTextPassword.getText().toString();

                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(LoginActivity.this,"Please enter your email or password ", Toast.LENGTH_SHORT).show();
                }
                else{

                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }}});

        //for changing status bar icon colors

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

    }




    public void onLoginClick(View View){
        startActivity(new Intent(this, com.iset.kadhytii.RegisterActivity.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }
}
