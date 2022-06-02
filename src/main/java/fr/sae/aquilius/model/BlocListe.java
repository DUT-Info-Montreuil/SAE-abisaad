package fr.sae.aquilius.model;

import java.util.ArrayList;

public class BlocListe {

    public static ArrayList<Integer> BlocObstacle = BlocObtacle();

    public BlocListe(){
        BlocObtacle();
    }
    private static ArrayList<Integer> BlocObtacle() {
        ArrayList<Integer>listBloc = new ArrayList<>();
        listBloc.add(1);
        listBloc.add(2);
        listBloc.add(3);
        return listBloc;
    }

    public static boolean estUnBlocObstacle (int idBloc){
        return BlocListe.BlocObtacle().contains(idBloc);
    }

}


