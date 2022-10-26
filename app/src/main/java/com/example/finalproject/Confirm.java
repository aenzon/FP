package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Confirm extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Button btnToRooms = findViewById(R.id.btnToRoom);
        Button btnToPay = findViewById(R.id.btnToPay);
        TextView txtNameOut = findViewById(R.id.txtNameOut);
        TextView txtContactOut = findViewById(R.id.txtContactOut);
        TextView txtCkinOut = findViewById(R.id.txtCkinOut);
        TextView txtCkoutOut = findViewById(R.id.txtCkoutOut);
        TextView txtGuestOut = findViewById(R.id.txtGuestOut);
        TextView txtRoomOut = findViewById(R.id.txtRoomOut);
        ImageView imgRoom = findViewById(R.id.imgRoom);

        txtNameOut.setText(Form.guestName);
        txtContactOut.setText(Form.guestContact);
        txtCkinOut.setText(Form.guestIn);
        txtCkoutOut.setText(Form.guestOut);
        txtGuestOut.setText(Form.qtyGuest);
        txtRoomOut.setText(Rooms.room);
        imgRoom.setImageResource(Rooms.imgSrc);

        btnToRooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Confirm.this, Rooms.class);
                startActivity(i);
            }
        });

        btnToPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Confirm.this, Payment.class);
                startActivity(i);
            }
        });

    }

}
