package projet.compagnie;

import java.util.Date;

public class Reservation {
    private int numeroReservation;
    private Date dateReservation;
    private Vol vol;
    private passagers passager;

    public void annulerReservation() {
        // à compléter plus tard
    }

    public void modifierReservation(Vol nouveauVol) {
        this.vol = nouveauVol;
    }

    public String obtenirInformations() {
        return "Réservation n°" + numeroReservation;
    }
}
