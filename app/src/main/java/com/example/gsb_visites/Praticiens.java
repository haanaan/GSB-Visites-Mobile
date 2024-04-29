package com.example.gsb_visites;

import java.util.ArrayList;

public class Praticiens implements java.io.Serializable {
    private String nom;
    private String prenom;
    private String email;
    public ArrayList<Visites> visites;

    public Praticiens(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        visites = new ArrayList<>();
    }

    public String getEmail() { return email; }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ArrayList<Visites> getVisites() {
        return visites;
    }
}




