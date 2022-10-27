package com.example.finalproject;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Ref extends AppCompatActivity {

    TextView reference;
    Button next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ref);

        reference= findViewById(R.id.refNumber);
        next= findViewById(R.id.btnHome);


        reference.setText(Payment.refNum);

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                    Intent i = new Intent(Ref.this, MainActivity.class);
                    startActivity(i);
            }
        });
    }
}
