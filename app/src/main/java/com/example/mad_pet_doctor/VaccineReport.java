package com.example.mad_pet_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

import java.util.ArrayList;
import java.util.List;

public class VaccineReport extends ArrayAdapter<VaccineDetailsModal> {

    private Activity context;
    List<VaccineDetailsModal> vaccineDetailsModals;

    public VaccineReport(Activity context, List<VaccineDetailsModal> vaccineDetailsModals) {
        super(context, R.layout.vaccine_report_list, vaccineDetailsModals);
        this.context = context;
        this.vaccineDetailsModals = vaccineDetailsModals;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.vaccine_report_list_details, null, true);
        TextView textViewVRName = (TextView) listViewItem.findViewById(R.id.VR_name_list_textview);
        TextView textViewVRDate = (TextView) listViewItem.findViewById(R.id.VR_date_list_textview);
        TextView textViewVRPrice = (TextView) listViewItem.findViewById(R.id.VR_price_list_textview);


        VaccineDetailsModal vaccineDetailsModal = vaccineDetailsModals.get(position);
        textViewVRName.setText(vaccineDetailsModal.getVaccine_Name_Edt());
        textViewVRDate.setText(vaccineDetailsModal.getVaccine_Date_Edt());
        textViewVRPrice.setText(vaccineDetailsModal.getVaccine_Price_Edt());

        return listViewItem;
    }

}
    /*@Override
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

    }*/
