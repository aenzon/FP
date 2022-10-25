package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Terms extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);
    }
    public void showAct(View v){
        String btnTxt;
        btnTxt = ((Button) v).getText().toString();

        if(btnTxt.equals("Accept")){
            Intent i = new Intent(this, Form.class);
            startActivity(i);
        }
        else if(btnTxt.equals("Back")){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

    }
}
