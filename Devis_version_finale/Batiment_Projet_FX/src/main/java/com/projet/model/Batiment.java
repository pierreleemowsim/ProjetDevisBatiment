package com.projet.model;
public abstract class Batiment {
    protected String idBatiment;
    protected int nbrNiveaux;

    public Batiment(String idBatiment, int nbrNiveaux) {
        this.idBatiment = idBatiment;
        this.nbrNiveaux = nbrNiveaux;
    }

    public abstract double devisBatiment();
    public abstract double surfaceRevetement(int idRevetement);

    public double devisRevetement(int idRevetement) { return 0.0; }
    public void dessiner() { }

    // Getter pour le nom (pour remplacer getNom())
    public String getIdBatiment() {
        return this.idBatiment;
    }

    public abstract double getSurfaceTotale();

   
}