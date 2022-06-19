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


    public boolean isCliqueDroit() {
        return cliqueDroit;
    }

    public boolean isCliqueGauche() {
        return cliqueGauche;
    }

    public int getSourisY() {
        return SourisY.get();
    }

    public IntegerProperty sourisYProperty() {
        return SourisY;
    }

    public int getSourisX() {
        return SourisX.get();
    }

    public IntegerProperty sourisXProperty() {
        return SourisX;
    }

    public void mouseManager() {
        /* Quand la Souris se deplace dans la map */
        paneMap.addEventHandler(MouseEvent.ANY, e -> {
            SourisX.setValue((int) e.getX());
            SourisY.setValue((int) e.getY());
        });

        /* Quand on appuie soit sur le clique droite ou le clique gauche de la souris */
        paneMap.setOnMousePressed(s -> {
            if(s.getButton() == MouseButton.PRIMARY){
                cliqueGauche = true;
                
                System.out.println("Mouse Clicked gauche");

            }else if(s.getButton() == MouseButton.SECONDARY){
                cliqueDroit = true;
                System.out.println("Mouse Clicked droit");
            }
        });

        /* Quand arrete d'appuier soit sur le clique droite ou le clique gauche de la souris */
        paneMap.setOnMouseReleased(s -> {
            if(s.getButton() == MouseButton.PRIMARY){
                cliqueGauche = false;

            }else if(s.getButton() == MouseButton.SECONDARY){
                cliqueDroit = false;
            }
        });
    }
}
