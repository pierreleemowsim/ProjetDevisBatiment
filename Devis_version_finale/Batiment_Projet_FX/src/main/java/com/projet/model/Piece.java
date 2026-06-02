package com.projet.model;
import java.util.ArrayList;
import java.util.List;

public class Piece {
    private int idPiece;
    private List<Coin> coins;
    private List<Mur> murs;
    private Sol sol;
    private Plafond plafond;

    public Piece(int idPiece) {
        this.idPiece = idPiece;
        this.coins = new ArrayList<>();
        this.murs = new ArrayList<>();
    }

    public int getIdPiece() {
    return this.idPiece; 
}

    public void ajouterCoin(Coin c) { this.coins.add(c); }
    public void ajouterMur(Mur m) { this.murs.add(m); }
    public void setSol(Sol s) { this.sol = s; }
    public void setPlafond(Plafond p) { this.plafond = p; }

    public double surface() {
        return sol != null ? sol.surface() : 0.0;
    }

    public double devisPiece(double hauteurSousPlafond) {
        double total = 0;
        if (sol != null) {
            for (Revetement r : sol.getRevetements()) total += r.montant(sol.surface());
        }
        if (plafond != null) {
            for (Revetement r : plafond.getRevetements()) total += r.montant(plafond.surface());
        }
        for (Mur m : murs) {
            double surfMur = m.surface(hauteurSousPlafond);
            for (Revetement r : m.getRevetements()) total += r.montant(surfMur);
        }
        return total;
    }

    public double surfaceRevetement(int idRevetement, double hauteurSousPlafond) {
        double totalSurface = 0;
        if (sol != null) {
            for (Revetement r : sol.getRevetements()) {
                if (r.getIdRevetement() == idRevetement) totalSurface += sol.surface();
            }
        }
        if (plafond != null) {
            for (Revetement r : plafond.getRevetements()) {
                if (r.getIdRevetement() == idRevetement) totalSurface += plafond.surface();
            }
        }
        for (Mur m : murs) {
            for (Revetement r : m.getRevetements()) {
                if (r.getIdRevetement() == idRevetement) totalSurface += m.surface(hauteurSousPlafond);
            }
        }
        return totalSurface;
    }

    public void dessiner() { }


}