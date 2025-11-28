package projet.compagnie;

public class employes extends Personne {
    protected String numeroEmploye;
    protected String dateEmbauche;

    public String obtenirRole() {
        return "Employé";
    }
}
