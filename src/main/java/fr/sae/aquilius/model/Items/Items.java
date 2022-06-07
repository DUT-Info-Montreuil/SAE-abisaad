package fr.sae.aquilius.model.Items;

public class Items {

    private String nom;
/*    private int  idObjet;*/
    private int quantité;

    public Items(String nom, int quantité){
        this.nom=nom;
        this.quantité=quantité;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantité() {
        return this.quantité;

    }


    public String toString (){
        return "nom: " + this.getNom() + "quantité: " + this.getQuantité();
    }
}
