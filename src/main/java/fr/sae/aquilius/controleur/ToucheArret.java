package fr.sae.aquilius.controleur;

import fr.sae.aquilius.model.Personnage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

    public class ToucheArret implements EventHandler<KeyEvent> {

        private Personnage perso;

        public ToucheArret(Personnage perso) {
            this.perso = perso;
        }

        public void handle(KeyEvent e){
            System.out.println(e.getCode());

            switch(e.getCode()) {

                case D:
                    perso.arretDeplacementHeroDroite();
                    break;
                case Q:
                    perso.arretDeplacementHeroGauche();
                    break;
                case Z:
                    perso.arretDeplacementHeroHaut();
                    break;


                default:
                    break;

        }
    }

}
