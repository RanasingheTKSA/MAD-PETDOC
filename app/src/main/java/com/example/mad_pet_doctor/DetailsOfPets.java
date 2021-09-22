package com.example.mad_pet_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

public class DetailsOfPets extends AppCompatActivity {

    private TextView DetailsOfPetsHeading;
    private ImageView DogImage, CatImage;
    private Button DogButton, CatButton;
    private Chip HomeChip1, HomeChip2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_of_pets);

        DetailsOfPetsHeading = findViewById(R.id.detailsofpets);
        DogImage = findViewById(R.id.detailsofpetpageimage1);
        CatImage = findViewById(R.id.detailsofpetpageimage2);
        DogButton = findViewById(R.id.dogsbutton);
        CatButton = findViewById(R.id.catsbutton);
        HomeChip1 = findViewById(R.id.chip9);
        HomeChip2 = findViewById(R.id.chip13);

        HomeChip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailsOfPets.this, ActivityMainSideBar.class));
            }
        });
        HomeChip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailsOfPets.this, ActivityMainSideBar.class));
            }
        });

        //Dog Button Implementation
        DogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailsOfPets.this, Dog.class));
            }
        });

        //Cat Button Implementation
        CatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailsOfPets.this, Cat.class));
            }
        });
    }
}