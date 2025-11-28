package projet.compagnie;

public class pilotes extends employes {
    private String licence;
    private int heuresDeVol;

    public void affecterVol(Vol vol) {
        // on remplira plus tard
    }

    @Override
    public String obtenirRole() {
        return "Pilote";
    }
}
