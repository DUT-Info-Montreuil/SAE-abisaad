package fr.sae.aquilius.model;

import java.util.ArrayList;

public class TabBloc {
    private ArrayList<Bloc> listeBloc;
    private Terrain terrain;

    public TabBloc(Terrain terrain) {
        listeBloc = new ArrayList<>();
        this.terrain = terrain;
        BlocSolide();
    }

    public void BlocSolide() {

        int[][] codeTuiles = terrain.getCodeTuiles();

        for (int ligne = 0; ligne < codeTuiles.length; ligne++) {
            for (int col = 0; col < codeTuiles[ligne].length; col++) {

                int choix = codeTuiles[ligne][col];
                switch (choix) {
                    case 1:
                        listeBloc.add(new Bloc(1, false));
                        break;

                    case 2:
                        listeBloc.add(new Bloc(2, false));
                        break;

                    case 3:
                        listeBloc.add(new Bloc(3, false));
                        break;
                }
            }
        }
    }
}
