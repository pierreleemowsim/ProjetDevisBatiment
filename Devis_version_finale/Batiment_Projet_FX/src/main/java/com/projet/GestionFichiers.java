package com.projet;

import com.projet.model.Revetement;
import com.projet.view.BatimentView.PieceGraphique;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionFichiers {

    // ========================================================
    // 1. CHARGEMENT DU CATALOGUE DE REVÊTEMENTS
    // ========================================================
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
                int pm = Integer.parseInt(tokens[2]);
                int ps = Integer.parseInt(tokens[3]);
                int pp = Integer.parseInt(tokens[4]);
                double prix = Double.parseDouble(tokens[5]);

                liste.add(new Revetement(id, designation, pm, ps, pp, prix));
            }
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement du catalogue : " + e.getMessage());
        }
        return liste;
    }

    // ========================================================
    // 2. SAUVEGARDE DE LA STRUCTURE (Niveaux, Pièces, Points)
    // ========================================================
    public static void sauvegarderBatiment(String cheminFichier, List<PieceGraphique> piecesGraphiques) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(cheminFichier))) {
            for (PieceGraphique p : piecesGraphiques) {
                // Format de la ligne strict : idNiveau ; idAppart ; idPiece ; x ; y ; largeur ; longueur
                String ligne = p.idNiveau + ";" + 
                               p.idAppart + ";" + 
                               p.idPiece + ";" + 
                               p.px + ";" + 
                               p.py + ";" + 
                               p.largeur + ";" + 
                               p.longueur;
                bw.write(ligne);
                bw.newLine();
            }
            System.out.println("Bâtiment sauvegardé avec succès dans " + cheminFichier);
        } catch (IOException e) {
            System.out.println("Erreur lors du sauvegarde du batiment : " + e.getMessage());
        }
    }

   // ========================================================
    // 3. CHARGEMENT DE LA STRUCTURE
    // ========================================================
    public static List<PieceGraphique> chargerBatiment(String cheminFichier) {
        List<PieceGraphique> liste = new ArrayList<>();
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
                // Plus de t[7] ici, on s'arrête à la longueur !

                liste.add(new PieceGraphique(nv, ap, pc, x, y, lg, lon));
            }
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement du batiment : " + e.getMessage());
        }
        return liste;
    }
}