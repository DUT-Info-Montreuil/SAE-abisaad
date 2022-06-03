package fr.sae.aquilius.model.Items;

public class EmplacementInventaire {

    private int quantite;
    private Objet objet ;


    public EmplacementInventaire(int quantite, Objet objet){
        this.quantite=quantite;
        this.objet=objet;
    }

    public Objet getObjet() {
        return objet;
    }
    public int getQuantite() {
        return quantite;
    }

    public void setObjet(Objet objet) {
        this.objet = objet;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

}
