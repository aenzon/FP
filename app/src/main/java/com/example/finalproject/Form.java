package com.example.finalproject;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Form extends AppCompatActivity {
    public static String guestName, guestContact, qtyGuest, guestIn, guestOut;
    public static int daysStay;
    final Calendar cal = Calendar.getInstance();
    EditText txtCkin, txtCkout;
    Date d1, d2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Button btnToTerms, btnToRooms;
        EditText txtName, txtContact;
        Spinner spinGuest;

        btnToTerms = findViewById(R.id.btnToTerms);
        btnToRooms = findViewById(R.id.btnToRooms);
        txtName = findViewById(R.id.txtNameInp);
        txtContact = findViewById(R.id.txtContactInp);
        txtCkin = findViewById(R.id.txtCkinInp);
        txtCkout = findViewById(R.id.txtCkoutInp);
        spinGuest = findViewById(R.id.spinGuestInp);
        d1 = cal.getTime();
        d2 = cal.getTime();

        // to limit choices in number of guests
        String[] dropdown = {"1", "2", "3", "4"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, dropdown);
        spinGuest.setAdapter(adapter);


        // date picker for check-in date
        DatePickerDialog.OnDateSetListener ckinDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, month);
                cal.set(Calendar.DAY_OF_MONTH, day);
                updateCkin();
            }
        };

        txtCkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dpCkin = new DatePickerDialog(Form.this, ckinDate, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
                dpCkin.getDatePicker().setMinDate(System.currentTimeMillis());
                dpCkin.show();
            }
        });

        // date picker for check-out date
        DatePickerDialog.OnDateSetListener ckoutDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, month);
                cal.set(Calendar.DAY_OF_MONTH, day);
                updateCkout();
            }
        };

        txtCkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dpCkout = new DatePickerDialog(Form.this, ckoutDate, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
                dpCkout.getDatePicker().setMinDate(d1.getTime() + (1000 * 60 * 60 * 24));
                dpCkout.show();
            }
        });


        //OnClickListener for Back Button
        btnToTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Form.this, Terms.class);
                startActivity(i);
            }
        });

        //OnClickListener for Next Button
        btnToRooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String contact = txtContact.getText().toString();
                String guest = spinGuest.getSelectedItem().toString();
                String ckin = txtCkin.getText().toString();
                String ckout = txtCkout.getText().toString();

                if(name.isEmpty() || contact.isEmpty() || guest.isEmpty() || ckin.isEmpty() || ckout.isEmpty()){
                    Toast.makeText(Form.this, getString(R.string.inc_form), Toast.LENGTH_SHORT).show();
                } else {
                    long diffTime = d2.getTime() - d1.getTime();
                    daysStay = (int)((diffTime / (1000 * 60 * 60 * 24)) % 365);
                    guestName = name;
                    guestContact = contact;
                    qtyGuest = guest;
                    guestIn = ckin;
                    guestOut = ckout;
                    Intent i = new Intent(Form.this, Rooms.class);
                    startActivity(i);
                }
            }
        });


    }

    private void updateCkout() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy", Locale.US);
        txtCkout.setText(dateFormat.format(cal.getTime()));
        d2 = cal.getTime();
    }

    private void updateCkin(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy", Locale.US);
        txtCkin.setText(dateFormat.format(cal.getTime()));
        d1 = cal.getTime();
        Toast.makeText(this,String.valueOf(d1.getTime()), Toast.LENGTH_LONG).show();
    }

}