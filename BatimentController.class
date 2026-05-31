package com.projet.model;
import java.util.ArrayList;
import java.util.List;

public class Plafond {
    private double surfaceDefinie;
    private List<Revetement> revetements;

    public Plafond(double surfaceDefinie) {
        this.surfaceDefinie = surfaceDefinie;
        this.revetements = new ArrayList<>();
    }

    public void appliquerRevetement(Revetement r) {
        if (r.isPourPlafond()) {
            this.revetements.add(r);
        } else {
             // Au lieu d'écrire dans la console, on génère une vraie erreur Java
             throw new IllegalArgumentException("Le revêtement " + r.getDesignation() + " n'est pas conçu pour les plafonds.");
         }
    }   

    public List<Revetement> getRevetements() { return revetements; }
    public double surface() { return surfaceDefinie; }
    
    @Override
    public String toString() { return String.valueOf(surfaceDefinie); }
}