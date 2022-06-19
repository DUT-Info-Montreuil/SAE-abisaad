package fr.sae.aquilius.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Ennemie {


    private IntegerProperty x;
    private IntegerProperty y;

    private Terrain terrain;

    private StringProperty action;

    private int vitesse;

    private int compteurSaut;

    private boolean gauche;
    private boolean droite;
    private boolean haut;

    private boolean bas;

    private boolean saute;

    private boolean estEnVie = true;

    private int largeur ;
    private ObservableList<Integer> codeTuiles ;

    private final static int PIXEL = 32;


    public Ennemie(int x, int y, Terrain terrain){
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.action =new SimpleStringProperty("immobile");
        this.terrain = terrain;
        this.compteurSaut = 0;
        this.vitesse = 1;
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





    public void deplacerEnnemie(Personnage personnage){

        int xenn = this.getX();
        int yenn = this.getY();

        if (xenn < personnage.getX() && !collisionBloc('d')){
            xenn = (this.getX())+32;
            action.set("Droite");
            if(xenn <= 960)
                this.setX(this.getX()+this.vitesse);
        }

        else if (xenn > personnage.getX() &&!collisionBloc('g')){
            xenn = (this.getX()-this.vitesse);
            action.set("Gauche");
            if(xenn >= 0)
                this.setX(this.getX()-this.vitesse);
        }
        // Debut du saut
        if (yenn > personnage.getY() && !saute && estAuSol()){
        yenn = (this.getY()-this.vitesse);
             if(yenn >= 0) {
                 this.setY(this.getY() - this.vitesse);
                 action.set("Haut");
                 saute = true;
            }
        }
        // Pendant le saut
        else if (yenn > personnage.getY() && saute && !estAuSol()) {
             yenn = (this.getY()-this.vitesse);
             if(yenn >= 0) {
                 if (compteurSaut <= 34) {
                        this.setY(this.getY() - this.vitesse);
                        action.set("Haut");
                        compteurSaut++;
                 }else {
                        saute = false;
                        compteurSaut = 0;
                 }
             }
        } else if (!haut && saute) {

            saute = false;
            compteurSaut = 0;
            action.set("Bas");

        } else if(!estAuSol() && !collisionBloc('b')){
            action.set("Bas");
            appliqueGravite();

        } else if (!droite && !gauche) {
            action.set("immobile");
         }
    }




    public void DeplacementEnnemieDroite() { droite = true; }

    public void DeplacementEnnemieGauche() {
        gauche = true;
    }

    public void DeplacementEnnemieHaut() {
        haut = true;
    }
    public void arretDeplacementEnnemieDroite() {
        droite = false;
    }
    public void arretDeplacementEnnemieGauche() {
        gauche = false;
    }
    public void arretDeplacementEnnemieHaut() {
        haut = false;
    }





    public boolean collisionBloc(char t){
        boolean bloc ;
        int xEnn = this.getX();
        int yEnn = this.getY();


        if(terrain.getBlock(xEnn+40,yEnn) != 3 ){
            bloc = true;
        }
        else if(terrain.getBlock(xEnn,yEnn) != 3 ){
            bloc = true;
        }
        else if(terrain.getBlock(xEnn,yEnn-32) != 3 ){
            bloc = true;
        }
        else {
            bloc = false;
        }
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
            this.y.set((int)(this.y.getValue()+2));
        }

    }

    public int getEnnemie(int x, int y){
        int ennemie;
        ennemie = codeTuiles.get(getIndice(x,y));
        return ennemie;
    }

    public int getIndice(int x, int y) {

        return x/PIXEL + (y/PIXEL) * largeur;
    }

}
