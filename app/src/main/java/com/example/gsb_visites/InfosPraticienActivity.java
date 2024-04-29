package com.example.gsb_visites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.gsb_visites.databinding.ActivityInfosPraticienBinding;

import org.w3c.dom.Text;

public class InfosPraticienActivity extends AppCompatActivity {
    private ActivityInfosPraticienBinding binding;
    private Praticiens praticien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInfosPraticienBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        praticien = (Praticiens) getIntent().getSerializableExtra("praticien");
        if (praticien != null) {
            TextView textNomPraticien = findViewById(R.id.textNomPraticien);
            TextView textPrenomPraticien = findViewById(R.id.textPrenomPraticien);
            TextView textEmailPraticien = findViewById(R.id.textEmailPraticien);

            textNomPraticien.setText(praticien.getNom());
            textPrenomPraticien.setText(praticien.getPrenom());
            textEmailPraticien.setText(praticien.getEmail());
        }

    }
}