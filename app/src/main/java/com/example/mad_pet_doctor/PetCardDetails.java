package com.example.mad_pet_doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.model.PetCardModal;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class PetCardDetails extends AppCompatActivity {

    private TextView PCDHeading;
    private ImageView PCDImage;
    private SearchView PCDSearchBar;
    private TableLayout PCDTable;
    private TextView Column1Data, Column2Data, Column3Data;
    private ImageButton UpdateBtn, DeleteBtn;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String PetCardDetailsID;
    private PetCardModal petCardModal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_card_details);

        firebaseDatabase = FirebaseDatabase.getInstance();
        PCDHeading = findViewById(R.id.PetCardHeading);
        PCDImage = findViewById(R.id.PetCardImage);
        PCDSearchBar = findViewById(R.id.SearchBar);
        PCDTable = findViewById(R.id.Table);
        Column1Data = findViewById(R.id.petIdColumn);
        Column2Data = findViewById(R.id.PetNameColumn);
        Column3Data = findViewById(R.id.OwnerNameColumn);
        UpdateBtn = findViewById(R.id.PCDEditImageButton1);
        DeleteBtn = findViewById(R.id.PCDDeleteImageButton1);

        petCardModal = getIntent().getParcelableExtra("PetCard");
        if (petCardModal != null){
            Column1Data.setText(petCardModal.getPet_ID());
            Column2Data.setText(petCardModal.getPet_Name());
            Column3Data.setText(petCardModal.getPet_OwnerName());
            PetCardDetailsID = petCardModal.getPet_ID();
        }

        databaseReference = firebaseDatabase.getReference("PetCards");
        UpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Pet_ID = Column1Data.getText().toString();
                String Pet_Name = Column2Data.getText().toString();
                /*String Pet_Breed = Breed.getText().toString();
                String Pet_DateOfBirth = PetDateOfBirth.getText().toString();
                String Pet_Age = PetAge.getText().toString();
                String Pet_Gender = PetGender.getText().toString();
                String Pet_Weight = PetWeight.getText().toString();*/
                String Pet_OwnerName = Column3Data.getText().toString();

                Map<String, Object> map = new HashMap<>();
                map.put("Pet_ID", PetCardDetailsID);
                map.put("Pet_Name", Pet_Name);
                map.put("Pet_OwnerName", Pet_OwnerName);

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.updateChildren(map);
                        Toast.makeText(PetCardDetails.this,"Pet Card Updated..",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(PetCardDetails.this, PetCardDetails.class));

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(PetCardDetails.this, "Pet Card Updated Fail.. "+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        DeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeletePetCard();
            }
        });
    }

    private void DeletePetCard(){
        databaseReference.removeValue();
        Toast.makeText(this, "Pet Card Deleted..", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(PetCardDetails.this, PetCardDetails.class));
    }
}