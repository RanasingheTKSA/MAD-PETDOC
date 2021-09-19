package com.example.mad_pet_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsOfPets extends AppCompatActivity {

    private TextView DetailsOfPetsHeading;
    private ImageView DogImage, CatImage;
    private Button DogButton, CatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_of_pets);

        DetailsOfPetsHeading = findViewById(R.id.detailsofpets);
        DogImage = findViewById(R.id.detailsofpetpageimage1);
        CatImage = findViewById(R.id.detailsofpetpageimage2);
        DogButton = findViewById(R.id.dogsbutton);
        CatButton = findViewById(R.id.catsbutton);

        //Dog Button Implementation
        DogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one = new Intent(DetailsOfPets.this, Dog.class);
            }
        });

        //Cat Button Implementation
        CatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one = new Intent(DetailsOfPets.this, Cat.class);
            }
        });
    }
}