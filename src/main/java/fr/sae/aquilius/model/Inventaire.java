package fr.sae.aquilius.model;

import fr.sae.aquilius.model.Items.Items;
import javafx.scene.layout.TilePane;

import java.util.ArrayList;

public class Inventaire {

    private TilePane paneTerrain2;

    ArrayList<Items> inventaires;

    public Inventaire(TilePane paneTerrain2) {
        this.inventaires = new ArrayList<Items>();
        this.paneTerrain2 = paneTerrain2;
    }
    public void ajouterItems(Items items) {
            inventaires.add(items);
    }

}


