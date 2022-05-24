package fr.sae.aquilius.vue;

import fr.sae.aquilius.model.Personnage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PersonnageVue {

    private Pane paneMap;
    private  ImageView imagePersoP;
    private Personnage personnage;


    public PersonnageVue(Pane paneMap, Personnage personnage) {
        Image imgPers = null;

        try {
            imgPers = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/persoTerra.png"));
        } catch (FileNotFoundException e) { e.printStackTrace(); }

        this.imagePersoP = new ImageView(imgPers);
        this.paneMap = paneMap;
        this.personnage = personnage;
    }

    public void addImgPersonnage() {
        paneMap.getChildren().add(imagePersoP);
        imagePersoP.translateXProperty().bind(personnage.xProperty());
        imagePersoP.translateYProperty().bind(personnage.yProperty());
    }





}