package com.projet.model;
import java.util.ArrayList;
import java.util.List;

public class Immeuble extends Batiment {
    private int idImmeuble;
    private List<Niveau> niveaux;

    public Immeuble(String idBatiment, int nbrNiveaux, int idImmeuble) {
        super(idBatiment, nbrNiveaux);
        this.idImmeuble = idImmeuble;
        this.niveaux = new ArrayList<>();
    }

    // Version corrigée avec la bonne variable "this.niveaux"
    public Niveau getNiveau(int idNiveau) {
        for (Niveau nv : this.niveaux) { 
            if (nv.getIdNiveau() == idNiveau) { 
                return nv;
            }
        }
        // Si le niveau n'existe pas encore, on le crée (hauteur par défaut à 3.0 mètres) et on l'ajoute
        Niveau nouveauNiveau = new Niveau(idNiveau, 3.0);
        this.niveaux.add(nouveauNiveau);
        return nouveauNiveau;
    }

    public List<Niveau> getNiveaux() {
        return this.niveaux;
    }

    public void ajouterNiveau(Niveau n) { this.niveaux.add(n); }

    @Override
    public String toString() {
        return "--- IMMEUBLE : " + idBatiment + " | " + niveaux.size() + " niveaux ---";
    }

    @Override
    public double devisBatiment() {
        double total = 0;
        for (Niveau n : niveaux) total += n.devisNiveau();
        return total;
    }

    @Override
    public double surfaceRevetement(int idRevetement) {
        double total = 0;
        for (Niveau n : niveaux) total += n.surfaceRevetement(idRevetement);
        return total;
    }

    @Override
    public double getSurfaceTotale() {
        double total = 0;
        for (Niveau n : niveaux) {
            total += n.getSurfaceTotale();
        }
        return total;
    }

    public Niveau obtenirOuCreerNiveau(int idNiv, double hauteurParDefaut) {
        for (Niveau n : niveaux) {
            if (n.getIdNiveau() == idNiv) {
                return n;
            }
        }
        Niveau nouveauNiv = new Niveau(idNiv, hauteurParDefaut);
        this.ajouterNiveau(nouveauNiv);
        return nouveauNiv;
    }
}