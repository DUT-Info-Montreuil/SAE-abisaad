package fr.sae.aquilius.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Personnage{

    private IntegerProperty y;
    private IntegerProperty x;
    private boolean droite;
    private boolean gauche;
    private boolean bas;
    private boolean haut;
    private Terrain terrain;

    public Personnage (int x, int y, Terrain terrain) {
        super();
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.droite = false;
        this.gauche = false;
        this.bas = true;
        this.haut = false;
        this.terrain = terrain;
    }

    public int getX() {
        return this.x.getValue();
    }
    public int getY() {
        return this.y.getValue();
    }

    public void setX(int x) {
        this.x.set(x);
    }

    public void setY(int y) {
        this.y.set(y);
    }

    public IntegerProperty xProperty() {
        return x;
    }
    public IntegerProperty yProperty(){
        return y;
    }

    public void deplacer(){
        if (droite){
            this.setX(this.getX()+10);
        }
        else if (gauche){
            this.setX(this.getX()-10);
        }
        else if (haut){
            this.setY(this.getY()-10);
        }
        else if(bas && !estAuSol()){
            this.setY(this.getY()+10);
        }

        if (!haut)
            appliqueGravite();
    }

    public void arreter(){
        if (!droite){
            this.x.set(this.getX());
        }
        else if (!gauche){
            this.x.set(this.getX());
        }
        else if (!haut){
            this.y.set(this.getY());
        }
        else if(!bas){
            this.y.set(this.getY());
        }
    }



    public void DeplacementHeroDroite() { droite = true; }

    public void DeplacementHeroGauche() {
        gauche = true;
    }

    public void DeplacementHeroHaut() {
        haut = true;
        bas=false;
    }

/*    public void DeplacementHeroBas() {
        bas = true;
    }*/

    public void arretDeplacementHeroDroite() {
        droite = false;

    }

    public void arretDeplacementHeroGauche() {
        gauche = false;

    }

    public void arretDeplacementHeroHaut() {
        haut = false;
        bas = true;

    }
/*  public void arretDeplacementHeroBas() {
        bas = false;

    }*/

    public boolean estAuSol(){
        boolean sol ;
        int xPer = this.getX();
        int yPer = this.getY();

        if(terrain.getBlock(xPer,yPer+32) != 3 ){
            sol = true;
        }
        else if(terrain.getBlock(xPer+32,yPer+32)!=3){
            sol= true;
        }
        else {
            sol=false;
        }
        return sol;

    }

    public void appliqueGravite(){
        if(!estAuSol()){
            this.y.set((int)(this.y.getValue()+9.15));
        }

    }


}