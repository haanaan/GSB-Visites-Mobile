package com.example.gsb_visites;

import java.util.Date;
import java.util.ArrayList;
public class Visites implements java.io.Serializable {

    private Date date_visite;
    private String commentaire;
    private String praticien;
    private String visiteur;
    private String motif;

    public Visites(Date date_visite, String commentaire, String praticien, String visiteur, String motif) {
        this.date_visite = date_visite;
        this.commentaire = commentaire;
        this.praticien = praticien;
        this.visiteur = visiteur;
        this.motif = motif;

    }

    public Date getDate_visite() {
        return date_visite;
    }

    public void setDate_visite(Date date_visite) {
        this.date_visite = date_visite;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getPraticien() {
        return praticien;
    }

    public void setPraticien(String praticien) {
        this.praticien = praticien;
    }

    public String getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(String visiteur) {
        this.visiteur = visiteur;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }
}
