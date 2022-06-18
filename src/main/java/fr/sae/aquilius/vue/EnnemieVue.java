package fr.sae.aquilius.vue;

import fr.sae.aquilius.model.Ennemie;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class EnnemieVue {

    private Pane paneMap;

    private  ImageView imgEnnemieSkeleton;

    private Ennemie ennemie;


    public EnnemieVue(Pane paneMap, Ennemie ennemie) {
        Image imgSkeleton = null;

        try {
             imgSkeleton = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/Ennemie.png"));
        } catch (FileNotFoundException e) { e.printStackTrace(); }

        this.imgEnnemieSkeleton = new ImageView(imgSkeleton);
        this.paneMap = paneMap;
        this.ennemie = ennemie;
    }

    public void addImgEnnemie() {
        paneMap.getChildren().add(imgEnnemieSkeleton);
        imgEnnemieSkeleton.translateXProperty().bind(ennemie.xProperty());
        imgEnnemieSkeleton.translateYProperty().bind(ennemie.yProperty());
    }
}
