package com.example.finalproject;

import static com.example.finalproject.RefNum.rm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Reserve extends AppCompatActivity {

    TextView name, number, ci, co, pax, room;
    Button home;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        home= findViewById(R.id.btnBTHome);
        name= findViewById(R.id.txtGName);
        number= findViewById(R.id.txtGNo);
        ci= findViewById(R.id.txtGCi);
        co= findViewById(R.id.txtGCo);
        pax= findViewById(R.id.txtGPax);
        room= findViewById(R.id.txtGRoom);

        name.setText(String.valueOf(rm.getName()));
        number.setText(String.valueOf(rm.getContact()));
        ci.setText(String.valueOf(rm.getCkin()));
        co.setText(String.valueOf(rm.getCkout()));
        pax.setText(String.valueOf(rm.getGuests()));
        room.setText(String.valueOf(rm.getRoom()));
    }

    public void showActivity(View v)
    {
        String btnBTHome;
        btnBTHome = ((Button) v).getText().toString();

        if(btnBTHome.equals("Back to Home")){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}
