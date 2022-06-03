package fr.sae.aquilius.model.Items;

public class Objet {

    private String nom;
    private int  idObjet;

    public Objet(String nom, int idObjet){
        this.nom=nom;
        this.idObjet=idObjet;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdObjet() {
        return idObjet;
    }

    public void setIdObjet(int idObjet) {
        this.idObjet = idObjet;
    }

}
