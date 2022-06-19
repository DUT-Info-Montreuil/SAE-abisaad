package fr.sae.aquilius.vue;

import fr.sae.aquilius.model.Ennemie;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class EnnemieVue {

    private Pane paneMap;

    private  ImageView imgEnnemie;

    private Ennemie ennemie;

    private Image imgEnn = null;
    private Image imgEnnDroite = null;
    private Image imgEnnGauche = null;



    public EnnemieVue(Pane paneMap, Ennemie ennemie) {

        try {
            imgEnn = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/Ennemie.png"));
            imgEnnDroite = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/EnnemieDroite.gif"));
            imgEnnGauche = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/EnnemieGauche.png"));
        } catch (FileNotFoundException e) { e.printStackTrace(); }

        this.imgEnnemie = new ImageView(imgEnn);
        this.paneMap = paneMap;
        this.ennemie = ennemie;

        paneMap.getChildren().add(imgEnnemie);
        imgEnnemie.translateXProperty().bind(ennemie.xProperty());
        imgEnnemie.translateYProperty().bind(ennemie.yProperty());

        ennemie.actionProperty().addListener(action ->{
            if (((StringProperty)action).getValue().equals("Droite")){
                imgEnnemie.setImage(imgEnnDroite);
            } else if (((StringProperty)action).getValue().equals("Gauche")) {
                imgEnnemie.setImage(imgEnnGauche);
            } else if (((StringProperty)action).getValue().equals("immobile")) {
                imgEnnemie.setImage(imgEnn);
            }else if (((StringProperty)action).getValue().equals("Haut")) {
                imgEnnemie.setImage(imgEnn);
            } else if (((StringProperty)action).getValue().equals("Bas")) {
                imgEnnemie.setImage(imgEnn);
            }
        });

    }


}
