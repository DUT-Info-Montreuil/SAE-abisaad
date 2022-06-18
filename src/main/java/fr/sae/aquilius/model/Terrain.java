package fr.sae.aquilius.model;

import com.google.gson.stream.JsonReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileReader;

public class Terrain {

    private int largeur ;
    private int hauteur ;
    private final static int PIXEL = 32;
    private int sol ; // hauteur du sol
    private int plafond; //hauteur du plafond
    private ObservableList<Integer> codeTuiles ;


    public void lireTerrain() {
        boolean widthSave = false;
        int i = 0;
        int j = 0;

        try (FileReader fileReader = new FileReader("src/main/resources/fr/sae/aquilius/maps.json");
             JsonReader jsonReader = new JsonReader(fileReader))
        {
            //codeTuiles = new int[hauteur][largeur];
            codeTuiles = FXCollections.observableArrayList();
            // Ecrit la carte dans la mémoire.
            jsonReader.beginObject();
            while (jsonReader.hasNext())
            {
                jsonReader.nextName();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    codeTuiles.add(jsonReader.nextInt());
                    //j++;
                }
                jsonReader.endArray();
                //j = 0;
                //i++;
            }
            jsonReader.endObject();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public Terrain(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public ObservableList<Integer> getCodeTuiles() {

        return codeTuiles;
    }
    public int getBlock(int x, int y){
        int block;
        block = codeTuiles.get(getIndice(x,y));
        return block;
    }

    public int getIndice(int x, int y) {

        return x/PIXEL + (y/PIXEL) * largeur;
    }

}