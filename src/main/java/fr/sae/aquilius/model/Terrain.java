package fr.sae.aquilius.model;

import com.google.gson.stream.JsonReader;

import java.io.FileReader;

public class Terrain {

    private int largeur ;
    private int hauteur ;
    private int sol ; // hauteur du sol
    private int plafond; //hauteur du plafond
    private int[][] codeTuiles ;


    public void lireTerrain() {
        boolean widthSave = false;
        int i = 0;
        int j = 0;

        try (FileReader fileReader = new FileReader("src/main/resources/fr/sae/aquilius/maps.json");
             JsonReader jsonReader = new JsonReader(fileReader))
        {
            jsonReader.beginObject();
            // Deduit la taille de la carte.
            while (jsonReader.hasNext())
            {
                hauteur++;
                jsonReader.nextName();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.nextInt();
                    if (!widthSave) largeur++;
                }
                jsonReader.endArray();
                widthSave = true;
            }
            jsonReader.endObject();
        } catch (Exception e) { e.printStackTrace(); }


        try (FileReader fileReader = new FileReader("src/main/resources/fr/sae/aquilius/maps.json");
             JsonReader jsonReader = new JsonReader(fileReader))
        {
            codeTuiles = new int[hauteur][largeur];
            // Ecrit la carte dans la mémoire.
            jsonReader.beginObject();
            while (jsonReader.hasNext())
            {
                jsonReader.nextName();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    codeTuiles[i][j] = jsonReader.nextInt();
                    j++;
                }
                jsonReader.endArray();
                j = 0;
                i++;
            }
            jsonReader.endObject();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public Terrain(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public int[][] getCodeTuiles() {
        return codeTuiles;
    }
    public int getLargeur () {
        return this.largeur;
    }
    public int getHauteur () {
        return this.hauteur;
    }

    public int getBlock(int x, int y){
        int block;
        block = codeTuiles[y/32][x/32];

        return block;
    }

/*
    public boolean graviter(){
        boolean tombe = true;

        if(!estAuSol().){
            tombe=false;
            this.y.setY
        }

    }*/
}