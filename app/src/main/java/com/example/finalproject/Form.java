package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Form extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Button btnToTerms, btnToRooms;
        EditText txtName, txtContact, txtCkin, txtCkout;
        Spinner spinGuest;

        btnToTerms = findViewById(R.id.btnToTerms);
        btnToRooms = findViewById(R.id.btnToRooms);
        txtName = findViewById(R.id.txtNameInp);
        txtContact = findViewById(R.id.txtContactInp);
        txtCkin = findViewById(R.id.txtCkinInp);
        txtCkout = findViewById(R.id.txtCkoutInp);
        spinGuest = findViewById(R.id.spinGuestInp);

        // to limit choices in number of guests
        String[] dropdown = {"1", "2", "3", "4"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, dropdown);
        spinGuest.setAdapter(adapter);

        //Buttons onClickListener
        btnToTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Form.this, Terms.class);
                startActivity(i);
            }
        });

        btnToRooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Form.this, Rooms.class);
                startActivity(i);
            }
        });


    }

}