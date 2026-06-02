package com.projet.model;
import java.util.ArrayList;
import java.util.List;

public class Maison extends Batiment {
    private int idMaison;
    private double hauteurSousPlafondUnique;
    private List<Piece> pieces;

    public Maison(String idBatiment, int nbrNiveaux, int idMaison, double hauteurSousPlafond) {
        super(idBatiment, nbrNiveaux);
        this.idMaison = idMaison;
        this.hauteurSousPlafondUnique = hauteurSousPlafond;
        this.pieces = new ArrayList<>();
    }

    public void ajouterPiece(Piece p) { this.pieces.add(p); }

    @Override
    public double getSurfaceTotale() {
        double total = 0;
        for (Piece p : pieces) total += p.surface();
        return total;
    }

    
    public void afficher() {
        System.out.println("--- MAISON : " + idBatiment + " | " + pieces.size() + " pièces ---");
    }

    @Override
    public double devisBatiment() {
        double total = 0;
        for (Piece p : pieces) total += p.devisPiece(this.hauteurSousPlafondUnique);
        return total;
    }

    @Override
    public double surfaceRevetement(int idRevetement) {
        double total = 0;
        for (Piece p : pieces) total += p.surfaceRevetement(idRevetement, this.hauteurSousPlafondUnique);
        return total;
    }
}