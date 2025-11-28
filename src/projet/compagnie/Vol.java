package projet.compagnie;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vol {
    private int numeroVol;
    private String origine;
    private String destination;
    private Date dateHeureDepart;
    private Date dateHeureArrivee;

    private avions avion;
    private List<employes> equipage = new ArrayList<>();
    private List<passagers> passagers = new ArrayList<>();

    public void affecterVol(employes e) {
        equipage.add(e);
    }

    public String obtenirVol() {
        return "Vol n°" + numeroVol + " de " + origine + " vers " + destination;
    }

    public void planifierVol() {
        // à compléter plus tard
    }

    public void annulerVol() {
        // à compléter plus tard
    }
}
