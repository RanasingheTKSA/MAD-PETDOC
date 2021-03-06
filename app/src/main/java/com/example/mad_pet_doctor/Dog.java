package com.example.mad_pet_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.chip.Chip;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dog extends AppCompatActivity {

    private TextView DogHeading;
    private ImageView DogIntroImage, DogBreedImage, DogGrowthImage, DogDiseasesImage;
    private Button DogIntroButton, DogBreedButton, DogGrowthButton, DogDiseasesButton;
    private Chip HomeChip1, HomeChip2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dog);

        DogHeading = findViewById(R.id.dogs);
        DogIntroImage = findViewById(R.id.imageView22);
        DogBreedImage = findViewById(R.id.imageView24);
        DogGrowthImage = findViewById(R.id.imageView26);
        DogDiseasesImage = findViewById(R.id.imageView25);

        DogIntroButton = findViewById(R.id.introduction);
        DogBreedButton = findViewById(R.id.originofbreed3);
        DogGrowthButton = findViewById(R.id.nutritionandgrowth);
        DogDiseasesButton =  findViewById(R.id.diseasesandvaccines);
        HomeChip1 = findViewById(R.id.chip9);
        HomeChip2 = findViewById(R.id.chip13);

        HomeChip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dog.this, ActivityMainSideBar.class));
            }
        });
        HomeChip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dog.this, ActivityMainSideBar.class));
            }
        });

        //Introduction Button Implementation
        DogIntroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dog.this, IntroductionDog.class));
            }
        });

        //Origin & Breed Button Implementation
        DogBreedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dog.this, DogOrignAndBreed.class));
            }
        });

        //Nutrition and Growth Button Implementation
        DogGrowthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dog.this, DogNutritionAndGrowth.class));
            }
        });

        //Diseases And Vaccines Button Implementation
        DogDiseasesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dog.this, DogDiseasesAndVaccines.class));
            }
        });
    }
}