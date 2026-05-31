package com.projet.model;

import java.util.ArrayList;
import java.util.List;

public class CatalogueManager {
    private static List<Revetement> listeRevetements = new ArrayList<>();

    static {
        // ID, Designation, pourMur(0/1), pourSol(0/1), pourPlafond(0/1), prix
        listeRevetements.add(new Revetement(1, "Peinture", 1, 0, 1, 10.95));
        listeRevetements.add(new Revetement(2, "Carrelage", 1, 1, 0, 49.75));
        listeRevetements.add(new Revetement(3, "Lambris", 1, 1, 1, 50.60));
        listeRevetements.add(new Revetement(4, "Marbre", 1, 1, 0, 97.85));
        listeRevetements.add(new Revetement(5, "Crepi", 1, 0, 0, 67.80));
        listeRevetements.add(new Revetement(6, "Papier peint", 1, 0, 0, 32.90));
        listeRevetements.add(new Revetement(7, "Plaquettes de parement", 1, 0, 0, 15.20));
        listeRevetements.add(new Revetement(8, "Peinture Haute Qualite", 1, 0, 1, 77.30));
        listeRevetements.add(new Revetement(9, "Peinture Eco", 1, 0, 1, 29.90));
        listeRevetements.add(new Revetement(10, "Carrelage Grand Format", 1, 1, 0, 89.45));
        listeRevetements.add(new Revetement(11, "Lambris Traite", 1, 1, 0, 42.50));
        listeRevetements.add(new Revetement(12, "Liege Mural", 1, 0, 0, 25.40));
        listeRevetements.add(new Revetement(13, "Parquet Chene", 0, 1, 0, 46.36));
        listeRevetements.add(new Revetement(14, "Vinyle Lino", 0, 1, 0, 23.55));
        listeRevetements.add(new Revetement(15, "Moquette Haute Densite", 0, 1, 0, 48.10));
        listeRevetements.add(new Revetement(16, "Stratifie", 0, 1, 0, 31.99));
        listeRevetements.add(new Revetement(17, "Gazon Synthetique", 0, 1, 0, 17.95));
        listeRevetements.add(new Revetement(18, "Liege Sol", 0, 1, 0, 33.90));
    }

    public static List<Revetement> getTousLesRevetements() {
        return listeRevetements;
    }

    public static Revetement findById(int id) {
        for (Revetement r : listeRevetements) {
            if (r.getIdRevetement() == id) return r;
        }
        return listeRevetements.get(0);
    }
}