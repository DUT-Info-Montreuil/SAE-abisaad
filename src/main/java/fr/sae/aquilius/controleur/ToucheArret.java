package fr.sae.aquilius.controleur;

import fr.sae.aquilius.model.Ennemie;
import fr.sae.aquilius.model.Personnage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

    public class ToucheArret implements EventHandler<KeyEvent> {

        private Ennemie ennemie;
        private Personnage perso;

        public ToucheArret(Personnage perso, Ennemie ennemie) {
            this.perso = perso;
            this.ennemie = ennemie;
        }

        public void handle(KeyEvent e){
            System.out.println(e.getCode());

            switch(e.getCode()) {

                case D:
                    perso.arretDeplacementHeroDroite();
                    /*ennemie.arretDeplacementEnnemieDroite();*/
                    break;
                case Q:
                    perso.arretDeplacementHeroGauche();
                    /*ennemie.arretDeplacementEnnemieGauche();*/
                    break;
                case Z:
                    perso.arretDeplacementHeroHaut();
                    /*ennemie.arretDeplacementEnnemieHaut();*/
                    break;


                default:
                    break;

        }
    }

}
