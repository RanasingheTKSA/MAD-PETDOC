package com.example.mad_pet_doctor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.model.PetCardModal;
import com.google.android.material.chip.Chip;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PetCardDetails extends AppCompatActivity {
    private RecyclerView scheduleApp;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private RelativeLayout  CardApp;
    private ArrayList<PetCardModal> petCardDetailsRVArrayList;
    private PetCardDetailsRVAdapter petCardDetailsRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_card_details);
        scheduleApp = findViewById(R.id.idAppSchedule);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("PetCards");
        petCardDetailsRVArrayList = new ArrayList<>();
        scheduleApp.setLayoutManager(new LinearLayoutManager(this));
        scheduleApp.setAdapter(petCardDetailsRVAdapter);
        CardApp = findViewById(R.id.homeCard);
        getAllPetCardDetails();
    }

    private void getAllPetCardDetails() {
        petCardDetailsRVArrayList.clear();
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot,
                                     @Nullable String previousChildName) {
                petCardDetailsRVArrayList.add(snapshot.getValue(PetCardModal.class));
                petCardDetailsRVAdapter.notifyDataSetChanged();;
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot,
                                        @Nullable String previousChildName) {
                petCardDetailsRVAdapter.notifyDataSetChanged();;
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                petCardDetailsRVAdapter.notifyDataSetChanged();;
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot,
                                     @Nullable String previousChildName) {
                petCardDetailsRVAdapter.notifyDataSetChanged();;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}