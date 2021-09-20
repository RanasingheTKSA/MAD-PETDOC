package com.example.mad_pet_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class VaccineReport extends AppCompatActivity {

    private TextView VRHeading;
    private ImageView VRImage;
    private TableLayout VRTable;
    private TextView Column1Data, Column2Data, Column3Data,Column4Data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vaccine_report);
    }
}