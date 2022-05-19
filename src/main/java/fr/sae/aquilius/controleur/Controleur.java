package fr.sae.aquilius.controleur;

import fr.sae.aquilius.model.Personnage;
import fr.sae.aquilius.model.Terrain;
import fr.sae.aquilius.vue.VuePersonnage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {

    @FXML
    BorderPane borderTerrain;
    @FXML
    Pane paneMap;
    @FXML
    TilePane paneTerrain;

    private Personnage personnage;
    private VuePersonnage vuePerso;

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("fghfghfghjghj");
        Terrain terrain = new Terrain(30, 20);
        terrain.lireTerrain();
        Personnage personnage = new Personnage(30,20);
        this.vuePerso = new VuePersonnage(paneMap,personnage);
        vuePerso.addImgPersonnage();
        int[][] codeTuiles = terrain.getCodeTuiles();

        borderTerrain.setOnKeyPressed(new Touche(personnage));


        Image ciel = null;
        Image sol = null;
        Image terre = null;
        try {
            ciel = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/ciel.png"));
            sol = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/sol.png"));
            terre = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/terre.png"));
        } catch (FileNotFoundException e) { e.printStackTrace(); }

        paneTerrain.setPrefRows(20);
        paneTerrain.setPrefColumns(30);

        for(int ligne=0 ; ligne<codeTuiles.length ;ligne++ ) {
            for(int col=0 ; col<codeTuiles[ligne].length; col++) {

                int choix = codeTuiles[ligne][col];
                switch(choix){
                    case 1:
                        this.paneTerrain.getChildren().add(new ImageView(sol));
                        break;

                    case 2:
                        this.paneTerrain.getChildren().add(new ImageView(terre));
                        break;

                    case 3:
                        this.paneTerrain.getChildren().add(new ImageView(ciel));
                        break;



                }

            }

        }
        System.out.println(personnage);
    }
}