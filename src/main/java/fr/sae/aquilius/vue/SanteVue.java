package fr.sae.aquilius.vue;

import fr.sae.aquilius.controleur.Controleur;
import fr.sae.aquilius.model.Personnage;
import javafx.beans.property.IntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SanteVue {

    private Pane paneMap;

    private ImageView barreSante;

    /*private ImageView barreSanteFull;*/

/*    private ImageView barreSanteTroisQuart;

    private ImageView barreSanteMoitie;

    private ImageView barreSanteUnQuart;

    private ImageView barreSanteVide;*/

    private Image bSFull = null;
    private Image bSTroisQuart = null;
    private Image bSMoitie = null;
    private Image bSUnQuart = null;
    private Image bSVide = null;

    public SanteVue(Pane paneMap, Personnage personnage) {


        try {
            bSFull = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/BarredeVieComplet.png"));
            bSTroisQuart = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/BarredeVieTroisQuart.png"));
            bSMoitie = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/BarredeVieUnDemi.png"));
            bSUnQuart = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/BarredeVieUnQuart.png"));
            bSVide = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/BarredeVieVide.png"));
        } catch (FileNotFoundException e) { e.printStackTrace(); }


        this.paneMap = paneMap;
        this.barreSante = new ImageView(bSFull);
        this.barreSante.setX(845);
        this.barreSante.setY(3);
        this.paneMap.getChildren().add(this.barreSante);
        personnage.getSante().addListener(sante ->{
            if (((IntegerProperty)sante).getValue() > 75 && ((IntegerProperty)sante).getValue() <= 100){
                this.barreSante.setImage(bSFull);

            } else if (((IntegerProperty)sante).getValue() > 50 && ((IntegerProperty)sante).getValue() <= 75) {
                this.barreSante.setImage(bSTroisQuart);

            }else if (((IntegerProperty)sante).getValue() > 25 && ((IntegerProperty)sante).getValue() <= 50){
                this.barreSante.setImage(bSMoitie);

            }else if (((IntegerProperty)sante).getValue() > 0 && ((IntegerProperty)sante).getValue() <= 25){
                this.barreSante.setImage(bSUnQuart);

            } else if (((IntegerProperty)sante).getValue() <= 0) {
                this.barreSante.setImage(bSVide);
            }
        });
    }



}
