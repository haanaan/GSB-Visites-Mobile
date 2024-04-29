package com.example.gsb_visites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gsb_visites.databinding.ActivityListPraticiensBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListPraticiensActivity extends AppCompatActivity {
    private ActivityListPraticiensBinding binding;
    private RecyclerView recyclerView;
    private PraticiensRecyclerViewAdapter adapter;
    private Visiteur visiteurApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListPraticiensBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Visiteur visiteur = (Visiteur) getIntent().getSerializableExtra("visiteur");
        visiteur.getNom();
        TextView textNomVisiteur = findViewById(R.id.textNomVisiteur);
        if (visiteur != null) {
            textNomVisiteur.setText(visiteur.getNom());
        }

        ArrayList<Praticiens> praticiens = new ArrayList<>();

        binding.recyclerViewPraticiens.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        binding.recyclerViewPraticiens.setLayoutManager(layoutManager);
        binding.recyclerViewPraticiens.setFocusable(false);

        PraticiensRecyclerViewAdapter myAdapterPraticiens = new PraticiensRecyclerViewAdapter(praticiens);
        binding.recyclerViewPraticiens.setAdapter(myAdapterPraticiens);

        GsbVisitesServices gsbVisitesServices = RetroFitClientInstance.getRetrofitInstance().create(GsbVisitesServices.class);
        Call<Visiteur> call = gsbVisitesServices.getVisiteur("Bearer " + visiteur.getToken(), visiteur.getVisiteurId());
        call.enqueue(new Callback<Visiteur>() {
            @Override
            public void onResponse(Call<Visiteur> call, Response<Visiteur> response) {
                visiteurApi = response.body();
                if (visiteurApi != null) {
                    for (Praticiens praticien : visiteurApi.getPortefeuillePraticiens()) {
                        praticiens.add(praticien);
                    }
                    myAdapterPraticiens.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Visiteur> call, Throwable t) {
                Toast.makeText(ListPraticiensActivity.this, "Une erreur est survenue !" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.recyclerViewPraticiens.addOnItemTouchListener(new PraticiensRecyclerTouchListener(getApplicationContext(), binding.recyclerViewPraticiens, new PraticiensRecyclerViewClickListener(){
            @Override
            public void onClick(View view, int position) {
                Praticiens praticien = praticiens.get(position);
                Intent intent = new Intent(getApplicationContext(), InfosPraticienActivity.class);
                intent.putExtra("praticien", praticien);
                startActivity(intent);
            }

        }));

    }


}
