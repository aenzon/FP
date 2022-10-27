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
    Button next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refnum);

        reference = findViewById(R.id.txtReference);
        next = findViewById(R.id.btnNext);



        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String ref = reference.getText().toString();

                if(ref.isEmpty()) {
                    Toast.makeText(RefNum.this, "Please enter your Reference Number.", Toast.LENGTH_SHORT).show();
                } else {

                }

            }

        });
    }
}

