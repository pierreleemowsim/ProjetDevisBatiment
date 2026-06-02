package com.projet.model;
public class Fenetre extends Ouverture {
    private int idFenetre;
    private double largeur = 1.20;
    private double hauteur = 1.20;

    public Fenetre(int idFenetre) { this.idFenetre = idFenetre; }
    public int getIdFenetre() { return idFenetre; }

    @Override
    public double surface() { return this.largeur * this.hauteur; }
}