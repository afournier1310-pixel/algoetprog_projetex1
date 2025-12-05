package projet.compagnie;

public class avions {

    private String immatriculation;
    private String modele;
    private int capacite;

    private boolean disponible = true;

    public avions() {
    }

    public avions(String immatriculation, String modele, int capacite) {
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.capacite = capacite;
    }


    public void affecterVol(Vol vol) {
        if (verifierDisponibilite()) {
            // ⚠️ ICI : plus de vol.setAvion(this) !
            System.out.println("Avion " + immatriculation + " affecté au " + vol.obtenirVol());
            disponible = false;
        } else {
            System.out.println("Avion " + immatriculation + " non disponible.");
        }
    }


    public boolean verifierDisponibilite() {
        return disponible;
    }


    public void liberer() {
        disponible = true;
    }


    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
}
