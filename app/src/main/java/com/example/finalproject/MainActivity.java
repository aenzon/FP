package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showAct(View v){
        String btnTxt;
        btnTxt = ((Button) v).getText().toString();

        if(btnTxt.equals("Reserve")){
            Intent i = new Intent(this,Terms.class);
            startActivity(i);
        }
        else if(btnTxt.equals("View Reservation")){
            Intent i = new Intent(this,RefNum.class);
            startActivity(i);
        }

    }
}