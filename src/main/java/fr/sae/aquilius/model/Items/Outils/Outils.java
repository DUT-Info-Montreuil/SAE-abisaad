package fr.sae.aquilius.model.Items.Outils;

import fr.sae.aquilius.model.Items.Items;

public class Outils extends Items {

    private int vitesseBuild;

    public Outils(String nom, int quantité, int vitesseBuild) {
        super(nom, quantité);
        this.vitesseBuild=vitesseBuild;
    }

    public int getVitesseBuild() {
        return vitesseBuild;
    }

}
