package com.projet;

import com.projet.model.Revetement;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionFichiers {

    public static List<Revetement> chargerCatalogue(String cheminFichier) {
        List<Revetement> liste = new ArrayList<>();
        File file = new File(cheminFichier);
        if (!file.exists()) {
            System.out.println("Erreur : Le fichier " + cheminFichier + " est introuvable au démarrage.");
            return liste;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                if (ligne.trim().isEmpty()) continue;
                String[] tokens = ligne.split(";");
                
                int id = Integer.parseInt(tokens[0]);
                String designation = tokens[1];
                // On récupère directement les entiers (0 ou 1) du fichier texte
                int pm = Integer.parseInt(tokens[2]);
                int ps = Integer.parseInt(tokens[3]);
                int pp = Integer.parseInt(tokens[4]);
                double prix = Double.parseDouble(tokens[5]);

                // On appelle ton constructeur exactement avec ses types d'origines
                liste.add(new Revetement(id, designation, pm, ps, pp, prix));
            }
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement du catalogue : " + e.getMessage());
        }
        return liste;
    }

    public static void sauvegarderBatiment(String cheminFichier, List<com.projet.view.BatimentView.PieceGraphique> piecesGraphiques) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(cheminFichier))) {
            for (com.projet.view.BatimentView.PieceGraphique p : piecesGraphiques) {
                String ligne = p.idNiveau + ";" + p.idAppart + ";" + p.idPiece + ";" + p.px + ";" + p.py + ";" + p.largeur + ";" + p.longueur;
                bw.write(ligne);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde du batiment : " + e.getMessage());
        }
    }

    public static List<com.projet.view.BatimentView.PieceGraphique> chargerBatiment(String cheminFichier) {
        List<com.projet.view.BatimentView.PieceGraphique> liste = new ArrayList<>();
        File file = new File(cheminFichier);
        if (!file.exists()) return liste;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                if (ligne.trim().isEmpty()) continue;
                String[] t = ligne.split(";");
                int nv = Integer.parseInt(t[0]);
                int ap = Integer.parseInt(t[1]);
                int pc = Integer.parseInt(t[2]);
                double x = Double.parseDouble(t[3]);
                double y = Double.parseDouble(t[4]);
                double lg = Double.parseDouble(t[5]);
                double lon = Double.parseDouble(t[6]);

                liste.add(new com.projet.view.BatimentView.PieceGraphique(nv, ap, pc, x, y, lg, lon));
            }
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement du batiment : " + e.getMessage());
        }
        return liste;
    }
}