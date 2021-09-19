package com.example.model;

import android.os.Parcel;
import android.os.Parcelable;

public class PetCardModal implements Parcelable {
    private String Pet_ID;
    private String Pet_Name;
    private String Pet_Breed;
    private String Pet_DateOfBirth;
    private String Pet_Age;
    private String Pet_Gender;
    private String Pet_Weight;
    private String Pet_OwnerName;

    public PetCardModal (){

    }

    public PetCardModal(String pet_ID, String pet_Name, String pet_Breed, String pet_DateOfBirth, String pet_Age, String pet_Gender, String pet_Weight, String pet_OwnerName) {
        Pet_ID = pet_ID;
        Pet_Name = pet_Name;
        Pet_Breed = pet_Breed;
        Pet_DateOfBirth = pet_DateOfBirth;
        Pet_Age = pet_Age;
        Pet_Gender = pet_Gender;
        Pet_Weight = pet_Weight;
        Pet_OwnerName = pet_OwnerName;
    }

    protected PetCardModal(Parcel in) {
        Pet_ID = in.readString();
        Pet_Name = in.readString();
        Pet_Breed = in.readString();
        Pet_DateOfBirth = in.readString();
        Pet_Age = in.readString();
        Pet_Gender = in.readString();
        Pet_Weight = in.readString();
        Pet_OwnerName = in.readString();
    }

    public static final Creator<PetCardModal> CREATOR = new Creator<PetCardModal>() {
        @Override
        public PetCardModal createFromParcel(Parcel in) {
            return new PetCardModal(in);
        }

        @Override
        public PetCardModal[] newArray(int size) {
            return new PetCardModal[size];
        }
    };

    public String getPet_ID() {
        return Pet_ID;
    }

    public void setPet_ID(String pet_ID) {
        Pet_ID = pet_ID;
    }

    public String getPet_Name() {
        return Pet_Name;
    }

    public void setPet_Name(String pet_Name) {
        Pet_Name = pet_Name;
    }

    public String getPet_Breed() {
        return Pet_Breed;
    }

    public void setPet_Breed(String pet_Breed) {
        Pet_Breed = pet_Breed;
    }

    public String getPet_DateOfBirth() {
        return Pet_DateOfBirth;
    }

    public void setPet_DateOfBirth(String pet_DateOfBirth) {
        Pet_DateOfBirth = pet_DateOfBirth;
    }

    public String getPet_Age() {
        return Pet_Age;
    }

    public void setPet_Age(String pet_Age) {
        Pet_Age = pet_Age;
    }

    public String getPet_Gender() {
        return Pet_Gender;
    }

    public void setPet_Gender(String pet_Gender) {
        Pet_Gender = pet_Gender;
    }

    public String getPet_Weight() {
        return Pet_Weight;
    }

    public void setPet_Weight(String pet_Weight) {
        Pet_Weight = pet_Weight;
    }

    public String getPet_OwnerName() {
        return Pet_OwnerName;
    }

    public void setPet_OwnerName(String pet_OwnerName) {
        Pet_OwnerName = pet_OwnerName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Pet_ID);
        dest.writeString(Pet_Name);
        dest.writeString(Pet_Breed);
        dest.writeString(Pet_DateOfBirth);
        dest.writeString(Pet_Age);
        dest.writeString(Pet_Gender);
        dest.writeString(Pet_Weight);
        dest.writeString(Pet_OwnerName);
    }
}
