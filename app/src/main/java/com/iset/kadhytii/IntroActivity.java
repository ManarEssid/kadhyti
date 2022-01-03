package com.iset.kadhytii;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;


public class IntroActivity extends Activity {

    private ConstraintLayout startbtn;
    private ImageView imageViewback,imageView2;
    private TextView textView , textView3,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        startbtn = findViewById(R.id.startbtn);
        imageViewback = findViewById(R.id.imageViewback);
        textView = findViewById(R.id.textView);
        textView3 = findViewById(R.id.textView3);
        textView2 = findViewById(R.id.textView2);
        imageView2 = findViewById(R.id.imageView2);




        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(IntroActivity.this, LoginActivity.class));
            }
        });
    }
}
