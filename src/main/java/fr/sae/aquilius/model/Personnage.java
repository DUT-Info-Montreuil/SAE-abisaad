package fr.sae.aquilius.model;

import fr.sae.aquilius.controleur.Controleur;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Personnage{

    public IntegerProperty sante;
    private IntegerProperty y;
    private IntegerProperty x;

    private StringProperty action;

    private int largeur ;

    private boolean droite;
    private boolean gauche;
    private boolean haut;

    private boolean saute;

    private int compteurSaut;

    private Terrain terrain;
    private Inventaire inventaire;

    private int vitesse;

    private ObservableList<Integer> codeTuiles ;

    private final static int PIXEL = 32;


    public Personnage (int x, int y, Terrain terrain,Inventaire inventaire, int sante) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.action =new SimpleStringProperty("immobile");
        this.droite = false;
        this.gauche = false;
        this.haut = false;
        this.saute = false;
        this.terrain = terrain;
        this.inventaire=inventaire;
        this.compteurSaut = 0;
        this.sante =  new SimpleIntegerProperty(sante);
        this.vitesse = 2;
    }

    public IntegerProperty getSante() {
        return this.sante;
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

    public String getAction() {
        return action.get();
    }

    public StringProperty actionProperty() {
        return action;
    }



    public boolean collisionBloc(char sens){
        boolean bloc ;
        int xPer = this.getX();
        int yPer = this.getY();
        System.out.println("Début systeme collision.");

        //Verification collision tête
        if((sens == 'd') && terrain.getBlock(xPer+32,yPer) != 3 ){
            bloc = true;
            System.out.println("Bloc droite.");
        }
        else if((sens == 'g') && terrain.getBlock(xPer,yPer) != 3 ){
            bloc = true;
            System.out.println("Bloc gauche.");
        }
        else {
            bloc = false;
            System.out.println("Il n ya pas de bloc.");
        }

        //Verification collision pied
        if((sens == 'd') && terrain.getBlock(xPer+32,yPer+30) != 3 ){
            bloc = true;
            System.out.println("Bloc droite.");
        }
        else if((sens == 'g') && terrain.getBlock(xPer,yPer+30) != 3 ){
            bloc = true;
            System.out.println("Bloc gauche.");
        }
        else {
            bloc = false;
            System.out.println("Il n ya pas de bloc.");
        }

        System.out.println("Fin systeme collision.");
        return bloc;

    }

    public void deplacer(){

        int xdes;
        int ydes;

        if (droite && !collisionBloc('d')){
            xdes = (this.getX())+32;
            action.set("Droite");
            if(xdes <= 960)
                this.setX(this.getX()+this.vitesse);
        }

        else if (gauche &&!collisionBloc('g')){
            xdes = (this.getX()-this.vitesse);
            action.set("Gauche");
            if(xdes >= 0)
                this.setX(this.getX()-this.vitesse);
        }
        // Debut du saut
        if (haut && !saute && estAuSol()){
            ydes = (this.getY()-this.vitesse);
            if(ydes >= 0) {
                this.setY(this.getY() - this.vitesse);
                action.set("Haut");
                saute = true;
            }
        }
        // Pendant le saut
        else if (haut && saute && !estAuSol()) {
            ydes = (this.getY()-this.vitesse);
            if(ydes >= 0) {
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

        } else if(!estAuSol() && !saute){
            action.set("Bas");
            appliqueGravite();

        }
        else if (!haut && !droite && !gauche) {
            action.set("immobile");
        }
    }

    public void DeplacementHeroDroite() { droite = true; }

    public void DeplacementHeroGauche() {
        gauche = true;
    }

    public void DeplacementHeroHaut() {
        haut = true;
    }
    public void arretDeplacementHeroDroite() {
        droite = false;
    }
    public void arretDeplacementHeroGauche() {
        gauche = false;
    }
    public void arretDeplacementHeroHaut() {
        haut = false;
    }


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
            this.y.set((int)(this.y.getValue()+2));
        }

    }

    public int getPersonnage(int x, int y){
        int personnage;
        personnage = codeTuiles.get(getIndice(x,y));
        return personnage;
    }

    public int getIndice(int x, int y) {

        return x/PIXEL + (y/PIXEL) * largeur;
    }

}