package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Payment extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
    }
    public void showAct(View v){
        String btnTxt;
        btnTxt = ((Button) v).getText().toString();

        if(btnTxt.equals("Confirm")){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        if(btnTxt.equals("Type of rooms")){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        if(btnTxt.equals("Home")){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

    }
}
