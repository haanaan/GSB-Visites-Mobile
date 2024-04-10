package com.example.gsb_visites;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PraticiensRecyclerViewAdapter extends RecyclerView.Adapter<PraticiensRecyclerViewAdapter.RecyclerViewHolder>{

    private List<Praticiens> praticiensList;

    public PraticiensRecyclerViewAdapter(List<Praticiens> praticiensList) {
        this.praticiensList = praticiensList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_praticiens, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Praticiens praticien = praticiensList.get(position);
        holder.praticienNom.setText(praticien.getNom());
        holder.praticienPrenom.setText(praticien.getPrenom());
    }

    @Override
    public int getItemCount() {
        return praticiensList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView praticienNom;
        TextView praticienPrenom;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            praticienNom = itemView.findViewById(R.id.praticienNom);
            praticienPrenom = itemView.findViewById(R.id.praticienPrenom);
        }
    }
}
