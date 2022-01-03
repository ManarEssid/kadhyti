package com.iset.kadhytii;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    TextView textView1,textView2,textView6,textView7,textView112,textView111;
    ImageView imageView1,imageView2,imageView3,imageView4;
    EditText editTextTextPersonName;
    ConstraintLayout constraintLayout1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView1= findViewById(R.id.textView1);
        textView2= findViewById(R.id.textView2);
        imageView1= findViewById(R.id.imageView1);
        editTextTextPersonName= findViewById(R.id.editTextTextPersonName);
        constraintLayout1= findViewById(R.id.constraintLayout1);
        imageView2= findViewById(R.id.imageView2);
        textView6= findViewById(R.id.textView6);
        textView7= findViewById(R.id.textView7);
        imageView3= findViewById(R.id.imageView3);
        imageView4= findViewById(R.id.imageView4);
        textView112= findViewById(R.id.textView112);
        textView111= findViewById(R.id.textView111);
        //showusername();
        bottomNavigation();
    }
    //private void showusername(){
      //  Intent intent =getIntent();
        //String Name = intent.getStringExtra("Name");
       // textView1.setText(Name);

   // }
    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.card_btn1);
        LinearLayout homeBtn = findViewById(R.id.home_btn1);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CardListActivity.class));
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, liv.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }

}