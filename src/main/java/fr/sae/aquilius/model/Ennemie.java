package fr.sae.aquilius.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ennemie {

    private IntegerProperty y;

    private IntegerProperty x;

    private Terrain terrain;

    private boolean gauche;
    private boolean droite;
    private boolean haut;
    private boolean bas;

    private boolean estEnVie = true;

    public Ennemie(int x, int y, Terrain terrain){
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.terrain = terrain;
    }


    public int getX() { return this.x.getValue(); }
    public int getY() {
        return this.y.getValue();
    }


    public void setX(int x) {
        this.x.set(x);
    }
    public void setY(int y) {
        this.y.set(y);
    }


    public IntegerProperty xProperty() { return x; }
    public IntegerProperty yProperty(){
        return y;
    }





    public void deplacerEnnemie(){

        int xEnn;
        int yEnn;

        if (droite && !collisionBloc('d')){
            xEnn = (this.getX())+32;
            if(xEnn <= 960)
                this.setX(this.getX()+10);
        }
        else if (gauche && !collisionBloc('g')){
            xEnn = (this.getX()-10);
            if(xEnn >= 0)
                this.setX(this.getX()-10);
        }
        else if (haut && !collisionBloc('g')){
            yEnn = (this.getY()-10);
            if(yEnn >= 0)
                this.setY(this.getY()-10);
        }
        else if(bas && !estAuSol()){
            this.setY(this.getY()+10);
        }
        if (!haut)
            appliqueGravite();
    }

    public boolean collisionBloc(char t){
        boolean bloc ;
        int xEnn = this.getX();
        int yEnn = this.getY();
        System.out.println("Début systeme collision.");

        if(terrain.getBlock(xEnn+32,yEnn) != 3 ){
            bloc = true;
            System.out.println("Bloc droite.");
        }
        else if(terrain.getBlock(xEnn,yEnn) != 3 ){
            bloc = true;
            System.out.println("Bloc gauche.");
        }
        else if(terrain.getBlock(xEnn,yEnn-32) != 3 ){
            bloc = true;
            System.out.println("Bloc haut.");
        }
        else {
            bloc = false;
            System.out.println("Il n ya pas de bloc.");
        }
        System.out.println("Fin systeme collision.");
        return bloc;


    }

    public boolean estAuSol(){
        boolean sol ;
        int xEnn = this.getX();
        int yEnn = this.getY();

        if(terrain.getBlock(xEnn,yEnn+32) != 3 ){
            sol = true;
        }
        else if(terrain.getBlock(xEnn+32,yEnn+32)!=3){
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
