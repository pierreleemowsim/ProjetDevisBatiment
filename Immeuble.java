package com.projet;

import com.projet.model.Immeuble;
import com.projet.view.BatimentView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // RÉSOLUTION DU CONSTRUCTEUR UNDEFINED : 
        // On passe les 3 paramètres requis par ton modèle : (idBatiment, nbrNiveaux, idImmeuble)
        Immeuble monImmeuble = new Immeuble("Bâtiment A", 5, 1);

        // On associe notre modèle à la vue
        BatimentView root = new BatimentView(monImmeuble);

        Scene scene = new Scene(root, 850, 650);
        primaryStage.setTitle("INSA - Gestionnaire de Bâtiment (MVC)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}