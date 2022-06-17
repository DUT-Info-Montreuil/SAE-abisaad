package fr.sae.aquilius.vue;

import fr.sae.aquilius.controleur.Controleur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SanteVue {

    private Pane paneMap;

    private ImageView barreSanteFull;

    private ImageView barreSanteTroisQuart;

    private ImageView barreSanteMoitie;

    private ImageView barreSanteUnQuart;

    private ImageView barreSanteVide;


    public SanteVue(Pane paneMap) {
        Image bSFull = null;
        Image bSTroisQuart = null;
        Image bSMoitie = null;
        Image bSUnQuart = null;
        Image bSVide = null;

        try {
            bSFull = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/BarredeVieComplet.png"));
            bSTroisQuart = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/BarredeVieTroisQuart.png"));
            bSMoitie = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/BarredeVieUnDemi.png"));
            bSUnQuart = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/BarredeVieUnQuart.png"));
            bSVide = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/BarredeVieVide.png"));
        } catch (FileNotFoundException e) { e.printStackTrace(); }

        this.barreSanteFull = new ImageView(bSFull);
        this.barreSanteTroisQuart = new ImageView(bSTroisQuart);
        this.barreSanteMoitie = new ImageView(bSMoitie);
        this.barreSanteUnQuart = new ImageView(bSUnQuart);
        this.barreSanteVide = new ImageView(bSVide);
        this.paneMap = paneMap;
    }


    public void addImgSante(int sante) {



        if (sante > 75 && sante <= 100){
            paneMap.getChildren().add(barreSanteFull);
            barreSanteFull.setX(845);
            barreSanteFull.setY(3);


        } else if (sante > 50 && sante <= 75) {
            paneMap.getChildren().add(barreSanteTroisQuart);
            barreSanteTroisQuart.setX(845);
            barreSanteTroisQuart.setY(3);

        }else if (sante > 25 && sante <= 50){
            paneMap.getChildren().add(barreSanteMoitie);
            barreSanteMoitie.setX(845);
            barreSanteMoitie.setY(3);

        }else if (sante > 0 && sante <= 25){
            paneMap.getChildren().add(barreSanteUnQuart);
            barreSanteUnQuart.setX(845);
            barreSanteUnQuart.setY(3);

        } else if (sante == 0) {
            paneMap.getChildren().add(barreSanteVide);
            barreSanteVide.setX(845);
            barreSanteVide.setY(3);
        }

    }


}
