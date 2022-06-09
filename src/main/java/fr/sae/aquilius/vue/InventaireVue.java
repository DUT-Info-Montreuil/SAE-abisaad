package fr.sae.aquilius.vue;

import fr.sae.aquilius.model.Inventaire;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class InventaireVue {
    private Pane paneMap;
    private ImageView imageEmplacementInventaire;
    private Inventaire inventaire ;

    public InventaireVue (Pane paneMap , Inventaire inventaire){
        Image emplacementInventaire = null;

        try {
            emplacementInventaire = new Image(new FileInputStream("fr/sae/aquilius/EmplacementInventaire.png"));
        } catch (FileNotFoundException e) { e.printStackTrace(); }

        this.imageEmplacementInventaire = new ImageView(emplacementInventaire);
        this.paneMap = paneMap;
        this.inventaire = inventaire;

    }

}
