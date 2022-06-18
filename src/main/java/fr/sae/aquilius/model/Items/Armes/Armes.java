package fr.sae.aquilius.model.Items.Armes;

import fr.sae.aquilius.model.Items.Items;

public class Armes extends Items {

    private int degats;

    public Armes(String nom, int quantite ,int degatsPV) {
        super(nom, quantite);
        this.degats =degats;
    }

/*    public int getDegats() {
        return degats;
    }*/
}
