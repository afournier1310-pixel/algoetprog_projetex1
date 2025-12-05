package projet.compagnie;

public class personnelcabine extends employes {

    public personnelcabine() {
        super();
        setRole("Personnel cabine");
    }

    @Override
    public String obtenirRole() {
        return "Personnel cabine";
    }

    @Override
    public String obtenirInfos() {
        return super.obtenirInfos() + " (Personnel cabine)";
    }
}
