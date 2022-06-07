package fr.sae.aquilius.model;

import fr.sae.aquilius.model.Items.Items;

import java.util.ArrayList;

public class Inventaire {

    ArrayList<Items> inventaires;

    public Inventaire() {
        this.inventaires= new ArrayList<Items>();
    }

    public void ajouterItems(Items items){
        inventaires.add(items);


    }


}
