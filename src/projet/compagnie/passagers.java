package projet.compagnie;

import java.util.ArrayList;
import java.util.List;

public class passagers extends Personne {

    private List<Reservation> reservations = new ArrayList<>();

    public passagers() {
        super();
    }


    public String getNom() {
        return nom;
    }


    public Reservation reserverVol(Vol vol) {
        Reservation r = new Reservation(vol, this);
        reservations.add(r);
        System.out.println("Le passager " + nom + " a réservé " + vol.obtenirVol());
        return r;
    }


    public void annulerReservation(int numeroReservation) {
        Reservation aSupprimer = null;

        for (Reservation r : reservations) {
            if (r.getNumeroReservation() == numeroReservation) {
                r.annulerReservation();
                aSupprimer = r;
                break;
            }
        }

        if (aSupprimer != null) {
            reservations.remove(aSupprimer);
            System.out.println("Réservation " + numeroReservation + " supprimée pour le passager " + nom);
        } else {
            System.out.println("Aucune réservation trouvée avec le numéro " + numeroReservation);
        }
    }


    public List<Reservation> obtenirReservations() {
        return reservations;
    }
}
