package com.example.mad_pet_doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
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
    private TextView PetID, VaccineName, VaccineDate, VaccinePrice;
    private EditText PetIdEdt, VaccineNameEdt, VaccineDateEdt, VaccinePriceEdt;
    private Button SAVE;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String petName;
    private VaccineDetailsModal vaccineDetailsModal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vaccine_details);

        VaccineDetailsHeading = findViewById(R.id.vaccinedetail);
        VaccineDetailsPageImage = findViewById(R.id.imageView10);
        VaccineName = findViewById(R.id.vaccinename);
        VaccineDate = findViewById(R.id.vaccinedate);
        VaccinePrice = findViewById(R.id.vaccineprice);
        VaccineNameEdt = findViewById(R.id.vaccinenameinput);
        VaccineDateEdt = findViewById(R.id.vaccinedateinput);
        VaccinePriceEdt = findViewById(R.id.vaccinepriceinput);
        SAVE = findViewById(R.id.SAVE);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("VaccineDetails");

        SAVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String Pet_Id_Edt = PetIdEdt.getText().toString();
                String Vaccine_Name_Edt = VaccineNameEdt.getText().toString();
                String Vaccine_Date_Edt = VaccineDateEdt.getText().toString();
                String Vaccine_Price_Edt = VaccinePriceEdt.getText().toString();
                petName = Vaccine_Name_Edt;

                VaccineDetailsModal vaccine_details_Model = new VaccineDetailsModal(petName,Vaccine_Date_Edt,Vaccine_Price_Edt);
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.child(petName).setValue(vaccine_details_Model);
                            Toast.makeText(VaccineDetails.this, "Vaccine Details Added.....", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(VaccineDetails.this, VaccineReport.class));
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