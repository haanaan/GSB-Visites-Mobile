package com.example.gsb_visites;

public class Praticiens implements java.io.Serializable {
    private String nom;
    private String prenom;

    public Praticiens(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}




