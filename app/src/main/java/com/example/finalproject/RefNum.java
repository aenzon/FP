package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RefNum extends AppCompatActivity {

    EditText reference;
    Button next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refnum);

        reference = findViewById(R.id.txtReference);
        next = findViewById(R.id.btnNext);
    }

    public void showActivity(View v)
    {
        String btnHome;
        btnHome = ((Button) v).getText().toString();

        if(btnHome.equals("Next")){
            Intent i = new Intent(this, Reserve.class);
            startActivity(i);
        }
    }
}

