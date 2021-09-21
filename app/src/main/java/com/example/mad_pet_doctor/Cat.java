package com.example.mad_pet_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Cat extends AppCompatActivity {

    private TextView CatHeading;
    private ImageView CatIntroImage, CatBreedImage, CatGrowthImage, CatDiseasesImage;
    private Button CatIntroButton, CatBreedButton, CatGrowthButton, CatDiseasesButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cat);

        CatHeading = findViewById(R.id.cats);
        CatIntroImage = findViewById(R.id.imageView13);
        CatBreedImage = findViewById(R.id.imageView30);
        CatGrowthImage = findViewById(R.id.imageView32);
        CatDiseasesImage = findViewById(R.id.imageView29);

        CatIntroButton = findViewById(R.id.catIntroduction);
        CatBreedButton = findViewById(R.id.catOridinOfBreed);
        CatGrowthButton = findViewById(R.id.catNutritionAndGrowth);
        CatDiseasesButton =  findViewById(R.id.catDiseasesAndVaccines);

        //Introduction Button Implementation
        CatIntroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one = new Intent(Cat.this, IntroductionCat.class);
                startActivity(new Intent(Cat.this, IntroductionCat.class));
            }
        });

        //Origin & Breed Button Implementation
        CatBreedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Cat.this, CatOriginOfBreed.class));
            }
        });

        //Nutrition and Growth Button Implementation
        CatGrowthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Cat.this, CatNutritionAndGrowth.class));
            }
        });

        //Diseases And Vaccines Button Implementation
        CatDiseasesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Cat.this, CatDiseasesAndVaccines.class));
            }
        });
    }
}