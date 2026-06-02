package com.projet.model;
import java.util.ArrayList;
import java.util.List;

public class Niveau {
    private int idNiveau;
    private double hauteurSousPlafond;
    private List<Appartement> apparts;

    public Niveau(int idNiveau, double hauteurSousPlafond) {
        this.idNiveau = idNiveau;
        this.hauteurSousPlafond = hauteurSousPlafond;
        this.apparts = new ArrayList<>();
    }

    public int getIdNiveau() { return idNiveau; }

    public void ajouterAppartement(Appartement a) { this.apparts.add(a); }

    public double devisNiveau() {
        double total = 0;
        for (Appartement a : apparts) total += a.devisAppartement(this.hauteurSousPlafond);
        return total;
    }

    public double surfaceRevetement(int idRevetement) {
        double total = 0;
        for (Appartement a : apparts) total += a.surfaceRevetement(idRevetement, this.hauteurSousPlafond);
        return total;
    }

    public double getSurfaceTotale() {
        double total = 0;
        for (Appartement a : apparts) {
            total += a.getSurfaceTotale();
        }
        return total;
    }

    public Appartement obtenirOuCreerAppartement(int idApp) {
    for (Appartement a : apparts) {
        // Même logique : on a besoin d'accéder à l'ID de l'appartement
        if (a.getIdAppart() == idApp) {
            return a;
        }
    }
    Appartement nouvelApp = new Appartement(idApp);
    this.ajouterAppartement(nouvelApp);
    return nouvelApp;
    }

    public Appartement getAppartement(int idAppart) {
    for (Appartement a : apparts) {
        if (a.getIdAppart() == idAppart) {
            return a;
        }
    }
    return null;

   
    

}

}