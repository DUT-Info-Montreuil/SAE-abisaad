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
    private ImageView imagePioche;
    private Inventaire inventaire ;

    public InventaireVue (Pane paneMap , Inventaire inventaire){
        Image emplacementInventaire = null;
        Image pioche = null;

        try {
            pioche= new Image(new FileInputStream("/home/etudiants/info/sabi/prive/S1/initiation_au_developpement/dev/SAE_Aquilius/src/main/resources/fr/sae/aquilius/Pioche.png"));
            emplacementInventaire = new Image(new FileInputStream("/home/etudiants/info/sabi/prive/S1/initiation_au_developpement/dev/SAE_Aquilius/src/main/resources/fr/sae/aquilius/EmplacementInventaire.png"));
        } catch (FileNotFoundException e) { e.printStackTrace(); }

        this.imageEmplacementInventaire = new ImageView(emplacementInventaire);
        this.imagePioche= new ImageView(pioche);
        this.paneMap = paneMap;
        this.inventaire = inventaire;

    }
    public void addImgEmplacementInventaire() {
        paneMap.getChildren().add(imageEmplacementInventaire);
    }
    public void addImgPioche() {
        paneMap.getChildren().add(imagePioche);
    }

}
