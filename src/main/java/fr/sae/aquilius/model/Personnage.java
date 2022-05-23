package fr.sae.aquilius.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Personnage {

    private IntegerProperty y;
    private IntegerProperty x;
    private boolean droite;
    private boolean gauche;
    private boolean bas;
    private boolean haut;

    public Personnage (int x, int y) {
        super();
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.droite = false;
        this.gauche = false;
        this.bas = false;
        this.haut = false;
    }

    public IntegerProperty getX() {
        return this.x;
    }
    public IntegerProperty getY() {
        return this.y;
    }




    public void deplacer(){
        if (droite){
            this.x.set(this.getX().getValue()+10);
        }
        else if (gauche){
            this.x.set(this.getX().getValue()-10);
        }
        else if (haut){
            this.getY().setValue(this.getY().getValue()-10);
        }
        else if(bas){
            this.getY().setValue(this.getY().getValue()+10);
        }
        System.out.println(bas);
    }

    public void arreter(){
        if (!droite){
            this.x.set(this.getX().getValue());
        }
        else if (!gauche){
            this.x.set(this.getX().getValue());
        }
        else if (!haut){
            this.y.set(this.getY().getValue());
        }
        else if(!bas){
            this.y.set(this.getY().getValue());
        }
    }



    public void DeplacementHeroDroite() {
        droite = true;
       // this.x.set(this.getX().getValue()+16);
    }

    public void DeplacementHeroGauche() {
        gauche = true;
        //this.x.set(this.getX().getValue()-16);
    }

    public void DeplacementHeroHaut() {
        haut = true;
        //this.getY().setValue(this.getY().getValue()-16);
    }

    public void DeplacementHeroBas() {
        bas = true;
        //this.getY().setValue(this.getY().getValue()+16);
    }

    public void arretDeplacementHeroDroite() {
        droite = false;
        // this.x.set(this.getX().getValue()+16);
    }

    public void arretDeplacementHeroGauche() {
        gauche = false;
        //this.x.set(this.getX().getValue()-16);
    }

    public void arretDeplacementHeroHaut() {
        haut = false;
        //this.x.set(this.getX().getValue()-16);
    }

    public void arretDeplacementHeroBas() {
        bas = false;
        //this.x.set(this.getX().getValue()-16);
    }
}