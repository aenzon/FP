package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Payment extends AppCompatActivity {
    TextView txtTotal, txtPayment, txtChange;
    Button btnBack, btnConfirm, btnHome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        txtTotal = findViewById(R.id.txt_TotIn);
        txtPayment = findViewById(R.id.txt_Pay);
        txtChange = findViewById(R.id.txt_Ch);
        btnBack = findViewById(R.id.btn_Back);
        btnConfirm = findViewById(R.id.btn_Confirm);
        btnHome = findViewById(R.id.btn_Home);

        txtTotal.setText(String.valueOf(Rooms.amount));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Payment.this, Confirm.class);
                startActivity(i);
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Payment.this, MainActivity.class);
                startActivity(i);
            }
        });
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DecimalFormat form = new DecimalFormat("0.00");

                Double change = (Double.parseDouble(txtPayment.getText().toString())) - Double.parseDouble(txtTotal.getText().toString());
                txtChange.setText(form.format(change));

                Intent i = new Intent(Payment.this, Ref.class);
                startActivity(i);
            }
        });
    }


}
