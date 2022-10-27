package com.example.finalproject;

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

    public Task<DataSnapshot> get(String id){
        return dbRef.child(id).get();
    }

}
