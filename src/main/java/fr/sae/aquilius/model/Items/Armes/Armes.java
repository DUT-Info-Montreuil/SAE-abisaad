package fr.sae.aquilius.model.Items.Armes;

import fr.sae.aquilius.model.Items.Items;

public class Armes extends Items {

    private int dégats;

    public Armes(String nom, int quantité ,int dégatsPV) {
        super(nom, quantité);
        this.dégats =dégats;
    }

    public int getDégats() {
        return dégats;
    }
}
