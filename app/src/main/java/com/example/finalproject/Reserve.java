package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Reserve extends AppCompatActivity {

    Button home;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        home= findViewById(R.id.btnBTHome);
    }

    public void showActivity(View v)
    {
        String btnBTHome;
        btnBTHome = ((Button) v).getText().toString();

        if(btnBTHome.equals("Okay")){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}
