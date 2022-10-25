package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Rooms extends AppCompatActivity implements View.OnClickListener{
    public static String room;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        Button btnSingle, btnDouble, btnTriple, btnQuad, btnToInfo;

        btnSingle = findViewById(R.id.btnSingle);
        btnDouble = findViewById(R.id.btnDouble);
        btnTriple = findViewById(R.id.btnTriple);
        btnQuad = findViewById(R.id.btnQuad);
        btnToInfo = findViewById(R.id.btnToInfo);

        btnSingle.setOnClickListener(this);
        btnDouble.setOnClickListener(this);
        btnTriple.setOnClickListener(this);
        btnQuad.setOnClickListener(this);

        btnToInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Rooms.this, Form.class);
                startActivity(i);
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnSingle:
                room = getString(R.string.rm_type1);
                break;
            case R.id.btnDouble:
                room = getString(R.string.rm_type2);
                break;
            case R.id.btnTriple:
                room = getString(R.string.rm_type3);
                break;
            case R.id.btnQuad:
                room = getString(R.string.rm_type4);
                break;
        }
        Intent i = new Intent(this, Confirm.class);
        startActivity(i);
    }
}
