package fr.sae.aquilius.controleur;

import fr.sae.aquilius.model.Ennemie;
import fr.sae.aquilius.model.Inventaire;
import fr.sae.aquilius.model.Personnage;
import fr.sae.aquilius.model.Terrain;
import fr.sae.aquilius.vue.*;
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

    private PersonnageVue vuePerso;
    private EnnemieVue vueEnnemie;
    private TerrainVue vueTerrain;
    private InventaireVue vueInventaire;

    public static SanteVue santeVue;


    private Timeline gameLoop;

    private Clique clique;

    public static Personnage personnage;


    public void initialize(URL location, ResourceBundle resources) {

        // Terrain //
        Terrain terrain = new Terrain(30, 20);
        terrain.lireTerrain();
        TerrainVue vueTerrain = new TerrainVue(paneTerrain, terrain);
        vueTerrain.addImgTuilles();
        // Terrain //

        //Inventaire//
        Inventaire inventaire = new Inventaire();
        InventaireVue vueInventaire = new InventaireVue(paneMap, inventaire);
        vueInventaire.addImgEmplacementInventaire();
        vueInventaire.addImgPioche();
        //Inventaire//


        // Personnage //
        personnage = new Personnage(180,350 ,terrain, inventaire, 100);
        PersonnageVue vuePerso = new PersonnageVue(paneMap, personnage);
        // Personnage //

        // Ennemie //
        Ennemie ennemie = new Ennemie(26,350 ,terrain);
        this.vueEnnemie = new EnnemieVue(paneMap,ennemie);

        // Ennemie //
        this.santeVue = new SanteVue(paneMap, personnage);
        // Sante//

        // Controle du Personnage //
        borderTerrain.setOnKeyPressed(new Touche(personnage,ennemie));
        borderTerrain.setOnKeyReleased(new ToucheArret(personnage,ennemie));
        // Controle du Personnage //


        // Controle de la souris sur la MAP //
        clique = new Clique(paneTerrain);
        clique.mouseManager();
        // Controle de la souris sur la MAP //

        paneTerrain.setPrefRows(20);
        paneTerrain.setPrefColumns(30);

        //gameloop//
        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)
                Duration.millis(16.33),
                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (ev ->{
                    personnage.deplacer();
                    ennemie.deplacerEnnemie(personnage);
                })
        );
        gameLoop.getKeyFrames().add(kf);
        gameLoop.play();
        //Gameloop//

    }

}