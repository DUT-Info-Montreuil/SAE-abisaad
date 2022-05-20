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

        Image sol = null;
        Image terre = null;
        Image ciel = null;

        try {
            ciel = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/ciel.png"));
            sol = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/sol.png"));
            terre = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/terre.png"));
        } catch (FileNotFoundException e) { e.printStackTrace(); }


        this.terrain = terrain;
        this.paneTerrain = paneTerrain;
        this.imageSol = new ImageView(sol);
        this.imageCiel = new ImageView(ciel);
        this.imageTerre = new ImageView(terre);


    }

  /*  public void addImgTuilles() {

//        terrain.lireTerrain();
        int[][] codeTuiles = terrain.getCodeTuiles();

        for (int ligne = 0; ligne < codeTuiles.length; ligne++) {
            for (int col = 0; col < codeTuiles[ligne].length; col++) {

                int choix = codeTuiles[ligne][col];
                switch (choix) {
                    case 1:
                        this.paneTerrain.getChildren().add(imageSol);
                        break;

                    case 2:
                        this.paneTerrain.getChildren().add(imageTerre);
                        break;

                    case 3:
                        this.paneTerrain.getChildren().add(imageCiel);
                        break;


                }
            }
        }
    }*/

}
