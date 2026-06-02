package com.projet.model;
public class Coin {
    private int idCoin;
    private double cx;
    private double cy;

    public Coin(int idCoin, double cx, double cy) {
        this.idCoin = idCoin;
        this.cx = cx;
        this.cy = cy;
    }

    public int getIdCoin() { return idCoin; }
    public double getCx() { return cx; }
    public double getCy() { return cy; }

    @Override
    public String toString() {
        return idCoin + ";" + cx + ";" + cy;
    }

    public void dessiner() { }
}