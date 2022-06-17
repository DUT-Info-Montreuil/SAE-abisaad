package fr.sae.aquilius.controleur;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class Clique {

    private Pane paneMap;

    private IntegerProperty SourisY;
    private IntegerProperty SourisX;

    private boolean cliqueDroit;
    private boolean cliqueGauche;



    public Clique (Pane paneMap){
        this.paneMap = paneMap;
        cliqueDroit = false;
        cliqueGauche = false;
        SourisX = new SimpleIntegerProperty();
        SourisY = new SimpleIntegerProperty();
    }


    public void mouseManager() {
        /* Quand la Souris se deplace dans la map */
        paneMap.setOnMouseMoved(s -> {
            SourisX.setValue((int) s.getX());
            SourisY.setValue((int) s.getY());
        });

        /* Quand on appuie soit sur le clique droite ou le clique gauche de la souris */
        paneMap.setOnMousePressed(s -> {
            if(s.getButton() == MouseButton.PRIMARY){
                SourisX.setValue((int) s.getX());
                SourisY.setValue((int) s.getY());
                cliqueDroit = true;
                
                System.out.println("Mouse Clicked gauche");

            }else if(s.getButton() == MouseButton.SECONDARY){
                SourisX.setValue((int) s.getX());
                SourisY.setValue((int) s.getY());
                cliqueGauche = true;
                System.out.println("Mouse Clicked droit");
            }
        });

        /* Quand arrete d'appuier soit sur le clique droite ou le clique gauche de la souris */
        paneMap.setOnMouseReleased(s -> {
            if(s.getButton() == MouseButton.PRIMARY){
                SourisX.setValue((int) s.getX());
                SourisY.setValue((int) s.getY());
                cliqueGauche = false;


            }else if(s.getButton() == MouseButton.SECONDARY){
                SourisX.setValue((int) s.getX());
                SourisY.setValue((int) s.getY());
                cliqueDroit = false;
            }
        });
    }
}
