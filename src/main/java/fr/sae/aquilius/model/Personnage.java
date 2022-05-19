package fr.sae.aquilius.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Personnage {

    private IntegerProperty y;
    private IntegerProperty x;

    public Personnage (int x, int y) {
        super();
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        int vitesse = 16;
    }

    public IntegerProperty getX() {
        return this.x;
    }
    public IntegerProperty getY() {
        return this.y;
    }
    public void setX(SimpleIntegerProperty x) {
        this.x = x;
    }
    public void setY(SimpleIntegerProperty y) {
        this.y = y;
    }

    public void DeplacementHeroDroite() {
        this.x.set(this.getX().getValue()+16);
    }
    public void DeplacementHeroGauche() {
        this.x.set(this.getX().getValue()-16);
    }
    public void DeplacementHeroHaut() {
        this.getY().setValue(this.getY().getValue()-16);
    }
    public void DeplacementHeroBas() {
        this.getY().setValue(this.getY().getValue()+16);
    }
}