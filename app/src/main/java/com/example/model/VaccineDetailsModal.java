package com.example.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RadioGroup;

public class VaccineDetailsModal implements Parcelable {
    String Pet_Id_Edt ;
    String Vaccine_Name_Edt ;
    String Vaccine_Date_Edt ;
    String Vaccine_Price_Edt ;
    RadioGroup Vaccinated_Or_Not;

    public VaccineDetailsModal(){}

    public VaccineDetailsModal(String pet_Id_Edt, String vaccine_Name_Edt, String vaccine_Date_Edt, String vaccine_Price_Edt, RadioGroup vaccinated_Or_Not) {
        Pet_Id_Edt = pet_Id_Edt;
        Vaccine_Name_Edt = vaccine_Name_Edt;
        Vaccine_Date_Edt = vaccine_Date_Edt;
        Vaccine_Price_Edt = vaccine_Price_Edt;
        Vaccinated_Or_Not = vaccinated_Or_Not;
    }

    protected VaccineDetailsModal(Parcel in) {
        Pet_Id_Edt = in.readString();
        Vaccine_Name_Edt = in.readString();
        Vaccine_Date_Edt = in.readString();
        Vaccine_Price_Edt = in.readString();
        
    }

    public static final Creator<VaccineDetailsModal> CREATOR = new Creator<VaccineDetailsModal>() {
        @Override
        public VaccineDetailsModal createFromParcel(Parcel in) {
            return new VaccineDetailsModal(in);
        }

        @Override
        public VaccineDetailsModal[] newArray(int size) {
            return new VaccineDetailsModal[size];
        }
    };

    public VaccineDetailsModal(String vaccine_name_edt, String vaccine_date_edt, String vaccine_price_edt, RadioGroup vaccinated_or_not, String petID) {
    }

    public String getPet_Id_Edt() {
        return Pet_Id_Edt;
    }

    public void setPet_Id_Edt(String pet_Id_Edt) {
        Pet_Id_Edt = pet_Id_Edt;
    }

    public String getVaccine_Name_Edt() {
        return Vaccine_Name_Edt;
    }

    public void setVaccine_Name_Edt(String vaccine_Name_Edt) {
        Vaccine_Name_Edt = vaccine_Name_Edt;
    }

    public String getVaccine_Date_Edt() {
        return Vaccine_Date_Edt;
    }

    public void setVaccine_Date_Edt(String vaccine_Date_Edt) {
        Vaccine_Date_Edt = vaccine_Date_Edt;
    }

    public String getVaccine_Price_Edt() {
        return Vaccine_Price_Edt;
    }

    public void setVaccine_Price_Edt(String vaccine_Price_Edt) {
        Vaccine_Price_Edt = vaccine_Price_Edt;
    }

    public RadioGroup getVaccinated_Or_Not() {
        return Vaccinated_Or_Not;
    }

    public void setVaccinated_Or_Not(RadioGroup vaccinated_Or_Not) {
        Vaccinated_Or_Not = vaccinated_Or_Not;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Pet_Id_Edt);
        dest.writeString(Vaccine_Name_Edt);
        dest.writeString(Vaccine_Date_Edt);
        dest.writeString(Vaccine_Price_Edt);
    }
}
