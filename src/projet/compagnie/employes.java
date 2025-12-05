package projet.compagnie;

public class employes extends Personne {

    protected String role;

    public employes() {
        super();
        this.role = "";
    }


    public String obtenirRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String obtenirInfos() {
        return super.obtenirInfos() + ", Rôle : " + role;
    }
}
