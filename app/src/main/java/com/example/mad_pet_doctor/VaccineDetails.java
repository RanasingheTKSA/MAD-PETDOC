package com.example.mad_pet_doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.model.VaccineDetailsModal;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileReader;

public class VaccineDetails extends AppCompatActivity {

    private TextView VaccineDetailsHeading;
    private ImageView VaccineDetailsPageImage;
    private TextView PetID, VaccineName, VaccineDate, VaccinePrice, Vaccinated;
    private EditText PetIdEdt, VaccineNameEdt, VaccineDateEdt, VaccinePriceEdt;
    private RadioGroup VaccinatedOrNot;
    private Button SAVE;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String petID;
    private VaccineDetailsModal vaccineDetailsModal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vaccine_details);

        //Text View for Heading
        VaccineDetailsHeading = findViewById(R.id.vaccinedetail);

        //Image View for Vaccine Detail Page
        VaccineDetailsPageImage = findViewById(R.id.imageView10);

        //Text View for the content heading
        PetID = findViewById(R.id.petid);
        VaccineName = findViewById(R.id.vaccinename);
        VaccineDate = findViewById(R.id.vaccinedate);
        VaccinePrice = findViewById(R.id.vaccineprice);
        Vaccinated = findViewById(R.id.vaccinated);

        //Edit input text
        PetIdEdt = findViewById(R.id.petidinput);
        VaccineNameEdt = findViewById(R.id.vaccinenameinput);
        VaccineDateEdt = findViewById(R.id.vaccinedateinput);
        VaccinePriceEdt = findViewById(R.id.vaccinepriceinput);

        //Radio group
        VaccinatedOrNot = findViewById(R.id.radioGroup);

        //Save button
        SAVE = findViewById(R.id.SAVE);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("VaccineDetails");

        SAVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Pet_Id_Edt = PetIdEdt.getText().toString();
                String Vaccine_Name_Edt = VaccineNameEdt.getText().toString();
                String Vaccine_Date_Edt = VaccineDateEdt.getText().toString();
                String Vaccine_Price_Edt = VaccinePriceEdt.getText().toString();
                RadioGroup Vaccinated_Or_Not = (RadioGroup) findViewById(R.id.radioGroup);
                petID = Pet_Id_Edt;

                VaccineDetailsModal vaccine_details_Model = new VaccineDetailsModal(Vaccine_Name_Edt,Vaccine_Date_Edt,Vaccine_Price_Edt,Vaccinated_Or_Not,petID);
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.child(petID).setValue(vaccineDetailsModal);
                            Toast.makeText(VaccineDetails.this, "Vaccine Details Added.....", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(VaccineDetails.this, MainActivity.class));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(VaccineDetails.this, "Error is "+error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
            }
        });
    }
}