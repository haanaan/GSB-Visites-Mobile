package com.example.gsb_visites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gsb_visites.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private Visiteur visiteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visiteur = new Visiteur();
                visiteur.setEmail(binding.editTextEmail.getText().toString());
                visiteur.setPassword(binding.editTextPassword.getText().toString());

                GsbVisitesServices gsbVisitesServices = RetroFitClientInstance.getRetrofitInstance().create(GsbVisitesServices.class);
                Call<Visiteur> call = gsbVisitesServices.login(visiteur);

                call.enqueue(new Callback<Visiteur>() {
                    @Override
                    public void onResponse(Call<Visiteur> call, Response<Visiteur> response) {
                        visiteur = response.body();
                        Toast.makeText(MainActivity.this, "Connexion réussie !", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onFailure(Call<Visiteur> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Une erreur est survenue !", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }
}