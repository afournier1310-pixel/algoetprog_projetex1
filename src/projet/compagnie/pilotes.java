package projet.compagnie;

public class pilotes extends employes {

    public pilotes() {
        super();
        setRole("Pilote");
    }

    @Override
    public String obtenirRole() {
        return "Pilote";
    }

    @Override
    public String obtenirInfos() {
        return super.obtenirInfos() + " (Pilote)";
    }
}
