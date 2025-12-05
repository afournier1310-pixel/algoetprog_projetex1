package projet.compagnie;

import java.util.Date;

public class Reservation {

    private static int compteur = 1;   // pour donner un ID unique

    private int numeroReservation;
    private Date dateReservation;
    private Vol vol;
    private passagers passager;
    private boolean annulee = false;

    public Reservation(Vol vol, passagers passager) {
        this.numeroReservation = compteur++;
        this.dateReservation = new Date();
        this.vol = vol;
        this.passager = passager;
    }

    public int getNumeroReservation() {
        return numeroReservation;
    }

    public Vol getVol() {
        return vol;
    }

    public passagers getPassager() {
        return passager;
    }

    public boolean estAnnulee() {
        return annulee;
    }


    public void annulerReservation() {
        annulee = true;
        System.out.println("Réservation " + numeroReservation + " annulée.");
    }


    public String obtenirInformations() {
        return "Réservation n°" + numeroReservation +
                " sur " + vol.obtenirVol() +
                " (passager : " + passager.getNom() + ")" +
                ", le " + dateReservation;
    }
}
