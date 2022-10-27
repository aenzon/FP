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

    ReservationModel rm = new ReservationModel();


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
                    dao.get(ref).addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            if(task.isSuccessful()){
                                if(task.getResult().exists()){
                                    DataSnapshot dataSnapshot = task.getResult();
                                    rm.setId(String.valueOf(dataSnapshot.child("id").getValue()));
                                    rm.setName(String.valueOf(dataSnapshot.child("name").getValue()));
                                    rm.setContact(String.valueOf(dataSnapshot.child("contact").getValue()));
                                    rm.setGuests(String.valueOf(dataSnapshot.child("guests").getValue()));
                                    rm.setCkin(String.valueOf(dataSnapshot.child("ckin").getValue()));
                                    rm.setCkout(String.valueOf(dataSnapshot.child("ckout").getValue()));
                                    rm.setRoom(String.valueOf(dataSnapshot.child("room").getValue()));
                                    Integer temp = Integer.parseInt(dataSnapshot.child("stay").getValue().toString());
                                    rm.setStay(temp);

                                    Toast.makeText(RefNum.this, "Record found", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(RefNum.this, Reserve.class);
                                    startActivity(i);
                                } else {
                                    Toast.makeText(RefNum.this, "No record found", Toast.LENGTH_SHORT).show();
                                }
                            } else{
                                System.out.println("Error in retrieving data");
                            }
                        }
                    });
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

