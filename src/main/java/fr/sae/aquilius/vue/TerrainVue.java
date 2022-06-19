package fr.sae.aquilius.vue;

import fr.sae.aquilius.controleur.Clique;
import fr.sae.aquilius.model.Terrain;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TerrainVue {

    private TilePane paneTerrain;
    private Terrain terrain;


    public TerrainVue(TilePane paneTerrain, Terrain terrain, Clique clique) {
        this.terrain = terrain;
        this.paneTerrain = paneTerrain;
        addImgTuilles();

    }

    public void addImgTuilles() {

        Image sol = null;
        Image terre = null;
        Image ciel = null;

        try {
            ciel = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/ciel.png"));
            sol = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/sol.png"));
            terre = new Image(new FileInputStream("src/main/resources/fr/sae/aquilius/terre.png"));
        } catch (FileNotFoundException e) { e.printStackTrace(); }

        ObservableList<Integer> codeTuiles = terrain.getCodeTuiles();

        for (int ligne = 0; ligne < codeTuiles.size(); ligne++) {

            int choix = codeTuiles.get(ligne);
            switch (choix) {
                case 1:
                    this.paneTerrain.getChildren().add(new ImageView(ciel));
                    break;

                case 2:
                    this.paneTerrain.getChildren().add(new ImageView(sol));
                    break;

                case 3:
                    this.paneTerrain.getChildren().add(new ImageView(terre));
                    break;
            }
        }

        codeTuiles.addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(Change<? extends Integer> c) {
                while (c.next()){

                    for(Object obj : c.getRemoved()){
                        System.out.println(c.getRemoved());
                        paneTerrain.getChildren().remove(obj);
                    }
                }
            }
        });
    }
}
