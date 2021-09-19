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

        //Text View for Headings
        PetCardHeading = findViewById(R.id.petcard);

        //Image View for picture
        PetCardImage = findViewById(R.id.imageView17);

        //Text View for labels
        petid = findViewById(R.id.petids);
        petname = findViewById(R.id.pcpetnames);
        breed = findViewById(R.id.pcbreeds);
        petdateofbirth = findViewById(R.id.pcdateofbirths);
        petage = findViewById(R.id.pcages);
        petgender = findViewById(R.id.pcgender);
        petweight = findViewById(R.id.pcweights);
        petownername = findViewById( R.id.pcownernames);

        //Edit Text
        PetID = findViewById(R.id.petidinputs);
        PetName = findViewById(R.id.pcpetname);
        Breed = findViewById(R.id.pcbreed);
        PetDateOfBirth = findViewById(R.id.pcdateofbirth);
        PetAge = findViewById(R.id.pcage);
        PetGender = findViewById(R.id.pcgenders);
        PetWeight = findViewById(R.id.pcweight);
        PetOwnerName = findViewById(R.id.psownername);
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
                        startActivity(new Intent(PetCard.this, MainActivity.class));
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