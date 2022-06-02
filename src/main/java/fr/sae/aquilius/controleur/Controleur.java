package fr.sae.aquilius.controleur;

import fr.sae.aquilius.model.Personnage;
import fr.sae.aquilius.model.Terrain;
import fr.sae.aquilius.vue.PersonnageVue;
import fr.sae.aquilius.vue.TerrainVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

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
    private PersonnageVue vuePerso;
    private TerrainVue vueTerrain;
    private Timeline gameLoop;


    public void initialize(URL location, ResourceBundle resources) {

        // TERRAIN //
        Terrain terrain = new Terrain(30, 20);
        terrain.lireTerrain();
        this.vueTerrain=new TerrainVue(paneTerrain,terrain);
        vueTerrain.addImgTuilles();
        int[][] codeTuiles = terrain.getCodeTuiles();
        // TERRAIN //

        // Personnage //
        Personnage personnage = new Personnage(180,350);
        this.vuePerso = new PersonnageVue(paneMap,personnage);
        vuePerso.addImgPersonnage();


        // Controle du Personnage //
        borderTerrain.setOnKeyPressed(new Touche(personnage));
        borderTerrain.setOnKeyReleased(new ToucheArret(personnage));
        // Controle du Personnage //


        paneTerrain.setPrefRows(20);
        paneTerrain.setPrefColumns(30);

            gameLoop = new Timeline();
            gameLoop.setCycleCount(Timeline.INDEFINITE);

            KeyFrame kf = new KeyFrame(
                    // on définit le FPS (nbre de frame par seconde)
                    Duration.seconds(0.1),
                    // on définit ce qui se passe à chaque frame
                    // c'est un eventHandler d'ou le lambda
                    (ev ->{
                        personnage.deplacer();
                        personnage.arreter();


                    })
            );
            gameLoop.getKeyFrames().add(kf);
            gameLoop.play();


    }
}