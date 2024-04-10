package com.example.gsb_visites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gsb_visites.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Praticiens praticiens;

    private Visiteur visiteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.editTextEmail.getText().toString();
                String password = binding.editTextPassword.getText().toString();
                Visiteur vis = new Visiteur(email, password);
                GsbVisitesServices gsbVisitesServices = RetroFitClientInstance.getRetrofitInstance().create(GsbVisitesServices.class);
                Call<Visiteur> call = gsbVisitesServices.login(vis);
                call.enqueue(new Callback<Visiteur>() {
                    @Override
                    public void onResponse(Call<Visiteur> call, Response<Visiteur> response) {
                        visiteur = response.body();
                        Intent intent = new Intent(getApplicationContext(), ListPraticiensActivity.class);
                        intent.putExtra("visiteur", visiteur);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Visiteur> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Une erreur est survenue !" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });


    }
}
