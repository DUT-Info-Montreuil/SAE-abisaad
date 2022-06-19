package fr.sae.aquilius.controleur;

import fr.sae.aquilius.model.Ennemie;
import fr.sae.aquilius.model.Personnage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Touche implements EventHandler<KeyEvent> {

    private Ennemie ennemie;
    private Personnage perso;

    public Touche(Personnage perso, Ennemie ennemie) {
        this.perso = perso;
        this.ennemie = ennemie;
    }


    public void handle(KeyEvent e){
        System.out.println(e.getCode());

        switch(e.getCode()) {

            case D:
                perso.DeplacementHeroDroite();
                /*ennemie.DeplacementEnnemieDroite();*/
                break;
            case Q:
                perso.DeplacementHeroGauche();
                /*ennemie.DeplacementEnnemieGauche();*/
                break;
            case Z:
                perso.DeplacementHeroHaut();
                /*ennemie.DeplacementEnnemieHaut();*/
                break;


            default:
                break;
        }
    }
}
