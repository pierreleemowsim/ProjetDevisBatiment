package com.projet.controller;

import com.projet.model.Immeuble;
import com.projet.model.Niveau;
import com.projet.model.Appartement;
import com.projet.model.Piece;

public class BatimentController {
    private Immeuble batiment;

    public BatimentController(Immeuble b) {
        this.batiment = b;
    }

    public Immeuble getBatiment() {
        return this.batiment;
    }

    /**
     * Enregistre une pièce dans la structure officielle du modèle (MVC)
     */
    public void enregistrerPieceDansModele(int idNiveau, int idAppart, Piece piece) {
        // 1. Récupère ou crée le niveau (hauteur par défaut de 2.5m)
        Niveau niveau = this.batiment.obtenirOuCreerNiveau(idNiveau, 2.5);
        
        // 2. Récupère ou crée l'appartement au sein de ce niveau
        Appartement appart = niveau.obtenirOuCreerAppartement(idAppart);
        
        // 3. Ajoute la pièce à l'appartement
        // (Vérifie si ta classe Appartement possède bien une méthode ajouterPiece)
        appart.ajouterPiece(piece);
    }

    // Outils de calculs géométriques pour l'IHM
    public double calculerSurfaceSolPlafond(double largeur, double longueur) {
        return largeur * longueur;
    }

    public double calculerSurfaceMurs(double largeur, double longueur, double hauteur) {
        return 2 * (largeur + longueur) * hauteur;
    }

    public void supprimerPieceDuModele(int idNiveau, int idAppart, int idPiece) {
        Niveau niveau = this.batiment.obtenirOuCreerNiveau(idNiveau, 2.5);
        if (niveau != null) {
            Appartement appart = niveau.obtenirOuCreerAppartement(idAppart);
            if (appart != null && appart.getPieces() != null) {
                appart.getPieces().removeIf(p -> p.getIdPiece() == idPiece);
            }
        }
    }
}