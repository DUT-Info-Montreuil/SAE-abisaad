package fr.sae.aquilius.controleur;

import fr.sae.aquilius.model.Personnage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Touche implements EventHandler<KeyEvent> {

    private Personnage perso;

    public Touche(Personnage perso) {
        this.perso = perso;
    }

    public void handle(KeyEvent e){
        System.out.println(e.getCode());

       // controleur.Controleur(persoTerra);
        switch(e.getCode()) {

            case D:
                perso.DeplacementHeroDroite();
                break;
            case Q:
                perso.DeplacementHeroGauche();
                break;
            case Z:
                perso.DeplacementHeroHaut();
                break;
       /*     case S:
                perso.DeplacementHeroBas();
                break;*/


            default:
                break;
        }
    }
}
