package projet.compagnie;

public class Personne {

    protected int identifiant;
    protected String nom;
    protected String adresse;
    protected String contact;

    public Personne() {
        this.identifiant = 0;
        this.nom = "";
        this.adresse = "";
        this.contact = "";
    }


    public String obtenirInfos() {
        return "ID : " + identifiant +
                ", Nom : " + nom +
                ", Adresse : " + adresse +
                ", Contact : " + contact;
    }
}
