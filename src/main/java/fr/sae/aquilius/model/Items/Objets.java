package fr.sae.aquilius.model.Items;

public class Objets extends Items {

    private int vitesseBuild;

    public Objets(String nom, int quantité, int vitesseBuild) {
        super(nom, quantité);
        this.vitesseBuild=vitesseBuild;
    }

    public int getVitesseBuild() {
        return vitesseBuild;
    }

}
