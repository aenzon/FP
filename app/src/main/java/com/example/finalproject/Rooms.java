package com.example.finalproject;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Rooms extends AppCompatActivity implements View.OnClickListener{
    public static String room;
    public static double amount;
    private final static double[] ROOM_PRICES = {1000, 2000, 3000, 4000}; //to edit

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


        // to set availability based on number of guests
        LinearLayout layoutSingle = findViewById(R.id.layoutSingle);
        LinearLayout layoutDouble = findViewById(R.id.layoutDouble);
        LinearLayout layoutTriple = findViewById(R.id.layoutTriple);

        if(Form.qtyGuest.equals("2") || Form.qtyGuest.equals("3") || Form.qtyGuest.equals("4")){
            layoutSingle.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.unavailable));
            layoutSingle.setBackgroundTintMode(PorterDuff.Mode.SRC_ATOP);
            btnSingle.setEnabled(false);
        }

        if(Form.qtyGuest.equals("3") || Form.qtyGuest.equals("4")){
            layoutDouble.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.unavailable));
            layoutDouble.setBackgroundTintMode(PorterDuff.Mode.SRC_ATOP);
            btnDouble.setEnabled(false);
        }

        if(Form.qtyGuest.equals("4")){
            layoutTriple.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.unavailable));
            layoutTriple.setBackgroundTintMode(PorterDuff.Mode.SRC_ATOP);
            btnTriple.setEnabled(false);
        }


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
                amount = Form.daysStay * ROOM_PRICES[0];
                break;
            case R.id.btnDouble:
                room = getString(R.string.rm_type2);
                amount = Form.daysStay * ROOM_PRICES[1];
                break;
            case R.id.btnTriple:
                room = getString(R.string.rm_type3);
                amount = Form.daysStay * ROOM_PRICES[2];
                break;
            case R.id.btnQuad:
                room = getString(R.string.rm_type4);
                amount = Form.daysStay * ROOM_PRICES[3];
                break;
        }
        Intent i = new Intent(this, Confirm.class);
        startActivity(i);
    }
}
