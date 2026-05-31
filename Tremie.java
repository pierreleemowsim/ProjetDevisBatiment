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
            // Comme idNiveau est privé dans Niveau, on suppose que tu as un getter ou on utilise la réflexion.
            // Si tu as une méthode getIdNiveau() dans Niveau.java, utilise : if (n.getIdNiveau() == idNiv)
            // Si tu n'as pas de getter, rajoute temporairement "public int getIdNiveau() { return idNiveau; }" dans Niveau.java
            if (n.getIdNiveau() == idNiv) {
                return n;
            }
        }
        Niveau nouveauNiv = new Niveau(idNiv, hauteurParDefaut);
        this.ajouterNiveau(nouveauNiv);
        return nouveauNiv;
    }
}