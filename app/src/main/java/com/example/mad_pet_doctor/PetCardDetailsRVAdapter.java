package com.example.mad_pet_doctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.PetCardModal;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PetCardDetailsRVAdapter extends RecyclerView.Adapter<PetCardDetailsRVAdapter.ViewHolder> {
    private ArrayList<PetCardModal> petCardDetailsRVArrayList;
    private Context context;
    int lastPos = -1;
    private ClickInterface clickInterface;

    public PetCardDetailsRVAdapter(ArrayList<PetCardModal> petCardDetailsRVArrayList, Context context, ClickInterface clickInterface) {
        this.petCardDetailsRVArrayList = petCardDetailsRVArrayList;
        this.context = context;
        this.clickInterface = clickInterface;
    }

    @Override
    public PetCardDetailsRVAdapter.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pet_card_details_rv,parent, false);
        return new  ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetCardDetailsRVAdapter.ViewHolder holder, int position) {
        PetCardModal petCardRVModal = petCardDetailsRVArrayList.get(position);
        holder.PetNameIV.setText(petCardRVModal.getPet_Name());
        holder.PetOwnerNameIV.setText(petCardRVModal.getPet_OwnerName());
        setAnimation(holder.itemView,position);
    }

    private void setAnimation(View itemView, int position) {
        if(position>lastPos){
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            itemView.setAnimation(animation);
            lastPos = position;
        }
    }

    @Override
    public int getItemCount() {
        return petCardDetailsRVArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView PetNameIV, PetOwnerNameIV;
        private ImageView PetIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            PetNameIV = itemView.findViewById(R.id.petnamecardview);
            PetOwnerNameIV = itemView.findViewById(R.id.petownernamecardview);
            PetIV = itemView.findViewById(R.id.pcdcardview);
        }
    }

    public interface ClickInterface{
        void onClick (int posotion);
    }
}
