package projet.compagnie;

public class personnelcabine extends employes {
    private String qualification;

    public void affecterVol(Vol vol) {
        // à compléter plus tard
    }

    @Override
    public String obtenirRole() {
        return "Personnel cabine";
    }
}
