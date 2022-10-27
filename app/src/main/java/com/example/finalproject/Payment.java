package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.text.DecimalFormat;

public class Payment extends AppCompatActivity {
    TextView txtTotal, txtPayment, txtChange;
    Button btnBack, btnConfirm, btnHome;
    public static String refNum;

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

        DecimalFormat form = new DecimalFormat("0,000.00");
        txtTotal.setText(form.format(Rooms.amount));

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
                String payment = txtPayment.getText().toString();
                String ch = txtChange.getText().toString();
                if(payment.isEmpty()){
                    Toast.makeText(Payment.this, "Enter payment", Toast.LENGTH_SHORT).show();
                } else if(ch.isEmpty()){
                    DecimalFormat form = new DecimalFormat("0,000.00");
                    Double change = (Double.parseDouble(payment)) - Rooms.amount;
                    txtChange.setText(form.format(change));

                } else {

                    ReservationModel rm = new ReservationModel(Form.guestName, Form.guestContact, Form.qtyGuest, Form.guestIn, Form.guestOut, Rooms.room, Form.daysStay);
                    DAOReservation dao = new DAOReservation();
                    dao.add(rm).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                refNum = rm.getId();
                                Toast.makeText(Payment.this, "Reservation Successful, Reference number is: " + refNum, Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Payment.this, "Failed to add reservation", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    Intent i = new Intent(Payment.this, Ref.class);
                    startActivity(i);
                }













            }
        });
    }


}
