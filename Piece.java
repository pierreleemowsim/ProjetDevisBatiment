package com.projet.model;
import java.util.ArrayList;
import java.util.List;

public class Appartement {
    private int idAppart;
    private List<Piece> pieces;

    public List<Piece> getPieces() {
    return this.pieces;
}

    public Appartement(int idAppart) {
        this.idAppart = idAppart;
        this.pieces = new ArrayList<>();
    }

    public int getIdAppart() { return idAppart; }

    public void ajouterPiece(Piece p) { this.pieces.add(p); }

    public double surface() {
        double total = 0;
        for (Piece p : pieces) total += p.surface();
        return total;
    }

    public double getSurfaceTotale() {
        return this.surface(); // Fait appel à ta méthode qui additionne déjà les pièces
    }

    public double devisAppartement(double hauteurSousPlafond) {
        double total = 0;
        for (Piece p : pieces) total += p.devisPiece(hauteurSousPlafond);
        return total;
    }

    public double surfaceRevetement(int idRevetement, double hauteurSousPlafond) {
        double total = 0;
        for (Piece p : pieces) total += p.surfaceRevetement(idRevetement, hauteurSousPlafond);
        return total;
    }

    public void dessiner() { }
}