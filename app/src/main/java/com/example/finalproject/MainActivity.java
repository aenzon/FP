package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnRes;
    Button btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRes = findViewById(R.id.btnReserve);
        btnView = findViewById(R.id.btnView);
    }
}