package com.projet.model;
import java.util.ArrayList;
import java.util.List;

public class Mur {
    private int idMur;
    private Coin debut;
    private Coin fin;
    private List<Revetement> revetements;
    private List<Ouverture> ouvertures;

    public Mur(int idMur, Coin debut, Coin fin) {
        this.idMur = idMur;
        this.debut = debut;
        this.fin = fin;
        this.revetements = new ArrayList<>();
        this.ouvertures = new ArrayList<>();
    }

    public void appliquerRevetement(Revetement r) {
        if (r.isPourMur()) {
            this.revetements.add(r);
        } else {
            System.out.println("Erreur: Le revêtement " + r.getDesignation() + " n'est pas conçu pour les murs.");
        }
    }

    public void ajouterOuverture(Ouverture o) { this.ouvertures.add(o); }
    public List<Revetement> getRevetements() { return revetements; }

    public double longueur() {
        return Math.sqrt(Math.pow(fin.getCx() - debut.getCx(), 2) + Math.pow(fin.getCy() - debut.getCy(), 2));
    }

    public double surface(double hauteurSousPlafond) {
        double surfaceBrute = longueur() * hauteurSousPlafond;
        double surfaceOuvertures = 0;
        for (Ouverture o : ouvertures) { surfaceOuvertures += o.surface(); }
        double surfaceNette = surfaceBrute - surfaceOuvertures;
        return surfaceNette < 0 ? 0 : surfaceNette;
    }

    @Override
    public String toString() { return idMur + ";" + debut.getIdCoin() + ";" + fin.getIdCoin(); }
    public void dessiner() { }
}