package projet.compagnie;

import java.util.ArrayList;
import java.util.List;

public class passagers extends Personne {

    private List<Reservation> reservations = new ArrayList<>();

    public void reserverVol(Vol vol) {
        // à compléter plus tard
    }

    public void annulerReservation(int numeroReservation) {
        // à compléter plus tard
    }

    public List<Reservation> obtenirReservations() {
        return reservations;
    }
}
