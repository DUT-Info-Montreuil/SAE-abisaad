package fr.sae.aquilius.model.Items.Nourriture;

import fr.sae.aquilius.model.Items.Items;

public class Nourriture extends Items {


    private int régénérationPV;

    public Nourriture(String nom, int quantité , int régénérationPV) {
        super(nom, quantité);
        this.régénérationPV =getRégénérationPV();
    }
    public int getRégénérationPV() {
        return régénérationPV;
    }

}
