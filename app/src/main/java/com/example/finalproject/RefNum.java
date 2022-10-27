package com.example.finalproject;

import static com.example.finalproject.Payment.refNum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;

import java.lang.ref.Reference;

public class RefNum extends AppCompatActivity {

    EditText reference;
    Button next, cancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refnum);

        reference = findViewById(R.id.txtReference);
        next = findViewById(R.id.btnNext);
        cancel = findViewById(R.id.btnCancel);



        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String ref = reference.getText().toString();

                if(ref.isEmpty()) {
                    Toast.makeText(RefNum.this, "Please enter your Reference Number.", Toast.LENGTH_SHORT).show();
                } else {
                    DAOReservation dao = new DAOReservation();
                    ReservationModel rm = dao.get(ref);

                    if (String.valueOf(reference.getText()).equals(Payment.refNum)) {
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), Reserve.class);
                        startActivity(i);

                    } else{
                        Toast.makeText(RefNum.this, "Failed", Toast.LENGTH_SHORT).show();
                    }


                }

            }

        });

        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RefNum.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}

