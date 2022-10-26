package com.example.finalproject;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOReservation {
    private final DatabaseReference dbRef;

    public DAOReservation() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("Reservations");
    }

    public Task<Void> add(ReservationModel rm){
        String id = dbRef.push().getKey();
        rm.setId(id);
        return dbRef.child(id).setValue(rm);
    }

    public ReservationModel get(String id){
        ReservationModel rm = new ReservationModel();
        dbRef.child(id).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()){
                    if(task.getResult().exists()){
                        DataSnapshot dataSnapshot = task.getResult();
                        rm.setId(id);
                        rm.setName(String.valueOf(dataSnapshot.child("name").getValue()));
                        rm.setContact(String.valueOf(dataSnapshot.child("contact").getValue()));
                        rm.setGuests(String.valueOf(dataSnapshot.child("guests").getValue()));
                        rm.setCkin(String.valueOf(dataSnapshot.child("ckin").getValue()));
                        rm.setCkout(String.valueOf(dataSnapshot.child("ckout").getValue()));
                        rm.setRoom(String.valueOf(dataSnapshot.child("room").getValue()));
                        rm.setStay((int)dataSnapshot.child("stay").getValue());
                    }
                }
            }
        });
        return rm;
    }

}
