package com.example.gsb_visites;

public class Praticiens implements java.io.Serializable {
    private String nom;
    private String prenom;
    private String email;

    public Praticiens(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public String getEmail() { return email; }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}




