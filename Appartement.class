package com.projet.model;

public class Revetement {
    private int idRevetement;
    private String designation;
    private boolean pourMur;
    private boolean pourSol;
    private boolean pourPlafond;
    private double prixUnitaire;

    public Revetement(int id, String des, int pm, int ps, int pp, double pu) {
        this.idRevetement = id;
        this.designation = des;
        this.pourMur = (pm == 1);
        this.pourSol = (ps == 1);
        this.pourPlafond = (pp == 1);
        this.prixUnitaire = pu;
    }

    public int getIdRevetement() { return idRevetement; }
    public String getDesignation() { return designation; }
    public boolean isPourSol() { return pourSol; }
    public boolean isPourMur() { return pourMur; }
    public boolean isPourPlafond() { return pourPlafond; }
    public double getPrixUnitaire() { return prixUnitaire; }

    public double montant(double surface) {
        return surface * prixUnitaire;
    }

    // ==========================================
    // AJOUTE LES LIGNES CI-DESSOUS ICI :
    // ==========================================
    @Override
    public String toString() {
        return this.designation; // Affiche proprement le nom (ex: "Carrelage") dans ton IHM
    }
}