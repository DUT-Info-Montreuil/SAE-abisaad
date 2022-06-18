package fr.sae.aquilius.vue;

import fr.sae.aquilius.model.Personnage;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PersonnageVue {

    private Pane paneMap;
    private  ImageView imagePersoP;
    private Personnage personnage;
    private Image imgPers = null;
    private Image imgPersDroite = null;
    private Image imgPersGauche = null;


    public PersonnageVue(Pane paneMap, Personnage personnage) {



        try {
            imgPers = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/persoTerra.png"));
            imgPersDroite = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/persoTerraDroite.gif"));
            imgPersGauche = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/persoTerraGauche.gif"));
        } catch (FileNotFoundException e) { e.printStackTrace(); }

        this.imagePersoP = new ImageView(imgPers);
        this.paneMap = paneMap;
        this.personnage = personnage;

        paneMap.getChildren().add(imagePersoP);
        imagePersoP.translateXProperty().bind(personnage.xProperty());
        imagePersoP.translateYProperty().bind(personnage.yProperty());

        personnage.actionProperty().addListener(action ->{
            if (((StringProperty)action).getValue().equals("Droite")){
                imagePersoP.setImage(imgPersDroite);
            } else if (((StringProperty)action).getValue().equals("Gauche")) {
                imagePersoP.setImage(imgPersGauche);
            } else if (((StringProperty)action).getValue().equals("immobile")) {
                imagePersoP.setImage(imgPers);
            }
        });
    }

/*
    public void addImgPersonnage() {

}
*/

}