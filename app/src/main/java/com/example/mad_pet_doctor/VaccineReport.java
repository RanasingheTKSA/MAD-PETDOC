package com.example.mad_pet_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.model.VaccineDetailsModal;
import com.google.android.material.chip.Chip;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VaccineReport extends AppCompatActivity {

    private TextView VRHeading;
    private ImageView VRImage;
    private ImageButton VRAddButton;
    private TableLayout VRTable;
    private TextView Column1Data, Column2Data, Column3Data,Column4Data;
    private Button DoneButton;
    private String VaccineReportID;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private VaccineDetailsModal vaccineDetailsModal;
    private Chip HomeChip1, HomeChip2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vaccine_report);

        //FirebaseDatabase Get Instance
        firebaseDatabase = FirebaseDatabase.getInstance();

        //Heading, Image, ImageButton
        VRHeading =  findViewById(R.id.vaccineReportHeading);
        VRImage = findViewById(R.id.vaccineReportImage);
        VRAddButton = findViewById(R.id.VaccineReportAddButton);
        VRTable = findViewById(R.id.Table2);
        Column1Data = findViewById(R.id.tablecoloum5);
        Column2Data = findViewById(R.id.tablecoloum6);
        Column3Data = findViewById(R.id.tablecoloum7);
        Column4Data = findViewById(R.id.tablecoloum8);
        DoneButton = findViewById(R.id.savebutton);
        HomeChip1 = findViewById(R.id.chip12);
        HomeChip2 = findViewById(R.id.chip15);

        HomeChip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VaccineReport.this, ActivityMainSideBar.class));
            }
        });
        HomeChip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VaccineReport.this, ActivityMainSideBar.class));
            }
        });

        VRAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VaccineReport.this, VaccineDetails.class));
            }
        });

        DoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VaccineReport.this, MainActivity.class));
            }
        });

    }
}