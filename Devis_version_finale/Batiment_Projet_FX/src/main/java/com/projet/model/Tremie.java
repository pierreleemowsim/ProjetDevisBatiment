package com.projet.model;
public class Tremie extends Ouverture {
    private int idTremie;
    private double largeur;
    private double longueur;

    public Tremie(int idTremie, double largeur, double longueur) {
        this.idTremie = idTremie;
        this.largeur = largeur;
        this.longueur = longueur;
    }

    @Override
    public double surface() { return this.largeur * this.longueur; }
}