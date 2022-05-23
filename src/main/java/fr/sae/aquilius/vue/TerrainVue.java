package fr.sae.aquilius.vue;

import fr.sae.aquilius.model.Terrain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TerrainVue {

    private TilePane paneTerrain;
    private Terrain terrain;
    private ImageView imageSol;
    private ImageView imageTerre;
    private ImageView imageCiel;


    public TerrainVue(TilePane paneTerrain, Terrain terrain) {

        this.terrain = terrain;
        this.paneTerrain = paneTerrain;

    }

    public void addImgTuilles() {

        Image sol = null;
        Image terre = null;
        Image ciel = null;

        try {
            ciel = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/ciel.png"));
            sol = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/sol.png"));
            terre = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/terre.png"));
            System.out.println("21656156");
        } catch (FileNotFoundException e) { e.printStackTrace(); }

        int[][] codeTuiles = terrain.getCodeTuiles();

        for (int ligne = 0; ligne < codeTuiles.length; ligne++) {
            for (int col = 0; col < codeTuiles[ligne].length; col++) {

                int choix = codeTuiles[ligne][col];
                switch (choix) {
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
    }

}
