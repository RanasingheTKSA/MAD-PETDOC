package com.example.mad_pet_doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.model.PetCardModal;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PetCard extends AppCompatActivity {

    private TextView PetCardHeading;
    private ImageView PetCardImage;
    private TextView petid, petname, breed, petdateofbirth, petage, petgender, petweight,petownername;
    private EditText PetID , PetName, Breed, PetDateOfBirth, PetAge,PetGender, PetWeight, PetOwnerName;
    private Button SAVE;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String petId;
    private PetCardModal petCardModal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_card);

        PetCardHeading = findViewById(R.id.petcard);
        PetCardImage = findViewById(R.id.imageView17);
        petid = findViewById(R.id.TVPetId);
        petname = findViewById(R.id.TVPetName);
        breed = findViewById(R.id.TVBreed);
        petdateofbirth = findViewById(R.id.TVPetDOB);
        petage = findViewById(R.id.TVPetAge);
        petgender = findViewById(R.id.TVPetGender);
        petweight = findViewById(R.id.TVPetWeight);
        petownername = findViewById( R.id.TVPetOwnerName);
        PetID = findViewById(R.id.ETPetId);
        PetName = findViewById(R.id.ETPetName);
        Breed = findViewById(R.id.ETPetBreed);
        PetDateOfBirth = findViewById(R.id.ETPetDOB);
        PetAge = findViewById(R.id.ETPetAge);
        PetGender = findViewById(R.id.ETPetGender);
        PetWeight = findViewById(R.id.ETPetWeight);
        PetOwnerName = findViewById(R.id.ETPetOwnerName);
        SAVE = findViewById(R.id.SAVE);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("PetCards");

        SAVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Pet_ID = PetID.getText().toString();
                String Pet_Name = PetName.getText().toString();
                String Pet_Breed = Breed.getText().toString();
                String Pet_DateOfBirth = PetDateOfBirth.getText().toString();
                String Pet_Age = PetAge.getText().toString();
                String Pet_Gender = PetGender.getText().toString();
                String Pet_Weight = PetWeight.getText().toString();
                String Pet_OwnerName = PetOwnerName.getText().toString();
                petId = Pet_ID;

                PetCardModal petcardModal = new PetCardModal(Pet_Name,Pet_Breed,Pet_DateOfBirth,Pet_Age,Pet_Gender,Pet_Weight,Pet_OwnerName,petId);
                    databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child(petId).setValue(petcardModal);
                        Toast.makeText(PetCard.this, "Pet Card Added.....", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(PetCard.this, PetCardDetails.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(PetCard.this, "Error is "+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}