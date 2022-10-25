package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Ref extends AppCompatActivity {

    TextView reference;
    Button next;
    public static int randomNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ref);

        reference= findViewById(R.id.refNumber);
        next= findViewById(R.id.btnHome);

        Random random = new Random();
        randomNumber = random.nextInt(4999-1000)+1000;
        reference.setText(String.valueOf(randomNumber+"001"));

    }
    public void showActivity(View v)
    {
        String btnHome;
        btnHome = ((Button) v).getText().toString();

        if(btnHome.equals("Okay")){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}
