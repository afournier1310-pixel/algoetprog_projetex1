package projet.compagnie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    private boolean annule = false;


    public Vol() {
    }

    public Vol(int numeroVol, String origine, String destination) {
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = new Date();
        this.dateHeureArrivee = new Date();
    }

    public int getNumeroVol() {
        return numeroVol;
    }

    public String getOrigine() {
        return origine;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDateHeureDepart() {
        return dateHeureDepart;
    }

    public Date getDateHeureArrivee() {
        return dateHeureArrivee;
    }




    public void planifierVol(int numeroVol, String origine, String destination,
                             Date dateHeureDepart, Date dateHeureArrivee) {
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
    }


    public void affecterVol(employes e) {
        equipage.add(e);
    }


    public void ajouterPassager(passagers p) {
        passagers.add(p);
    }


    public void setAvion(avions avion) {
        this.avion = avion;
    }


    public String obtenirVol() {
        return "Vol n°" + numeroVol + " de " + origine + " vers " + destination;
    }


    public void annulerVol() {
        annule = true;
        System.out.println(obtenirVol() + " est annulé.");
    }

    public boolean estAnnule() {
        return annule;
    }


    public static List<Vol> chargerVolsDepuisCSV(String cheminFichier) {
        List<Vol> vols = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;

            while ((ligne = br.readLine()) != null) {
                if (ligne.trim().isEmpty()) {
                    continue;
                }

                String[] parties = ligne.split(";");
                if (parties.length < 3) {
                    System.out.println("Ligne ignorée (mauvais format) : " + ligne);
                    continue;
                }

                int numero = Integer.parseInt(parties[0]);
                String origine = parties[1];
                String destination = parties[2];

                Vol v = new Vol(numero, origine, destination);
                vols.add(v);

                System.out.println("Vol chargé : " + numero + " " + origine + " → " + destination);
            }

            System.out.println("Import des vols terminé.");

        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erreur de numéro de vol (pas un entier) : " + e.getMessage());
        }

        return vols;
    }
}
