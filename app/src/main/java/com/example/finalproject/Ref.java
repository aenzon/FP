package com.example.finalproject;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Ref extends AppCompatActivity {

    ImageButton clip;
    TextView reference;
    Button next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ref);

        clip= findViewById(R.id.btnClip);
        reference= findViewById(R.id.refNumber);
        next= findViewById(R.id.btnHome);

        reference.setText(Payment.refNum);

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Ref.this, MainActivity.class);
                startActivity(i);
            }
        });

        clip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE); //
                ClipData clip = ClipData.newPlainText("Copy", reference.getText().toString());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(Ref.this, "Copied to clipboard!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
