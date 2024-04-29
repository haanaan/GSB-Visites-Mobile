package com.example.gsb_visites;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VisitesRecyclerViewAdapter extends RecyclerView.Adapter<VisitesRecyclerViewAdapter.RecyclerViewHolder>{

    private List<Visites> visitesList;

    public VisitesRecyclerViewAdapter(List<Visites> visitesList) {
        this.visitesList = visitesList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_visites, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Visites visite = visitesList.get(position);
        holder.textVisiteDate.setText(visite.getDate_visite().toString());
    }

    @Override
    public int getItemCount() {
        return visitesList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView textVisiteDate;
        public RecyclerViewHolder(@NonNull View itemView) {

            super(itemView);
            textVisiteDate = itemView.findViewById(R.id.textVisiteDate);
        }
    }
}
