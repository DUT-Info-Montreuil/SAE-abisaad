package fr.sae.aquilius.vue;

import fr.sae.aquilius.model.Inventaire;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class InventaireVue {
    private TilePane paneTerrain2;
    private ImageView imageEmplacementInventaire;
    private Inventaire inventaire ;

    public InventaireVue (TilePane paneTerrain2 , Inventaire inventaire){
        Image emplacementInventaire = null;

        try {
            emplacementInventaire = new Image(new FileInputStream("/home/etudiants/info/sabi/prive/S1/initiation_au_developpement/dev/SAE_Aquilius/src/main/resources/fr/sae/aquilius/EmplacementInventaire.png"));
        } catch (FileNotFoundException e) { e.printStackTrace(); }

        this.imageEmplacementInventaire = new ImageView(emplacementInventaire);
        this.paneTerrain2 = paneTerrain2;
        this.inventaire = inventaire;

    }
    public void addImgEmplacementInventaire() {
        paneTerrain2.getChildren().add(imageEmplacementInventaire);
    }

}
