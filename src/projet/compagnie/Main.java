package projet.compagnie;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Chargement de la compagnie ===");

        // 1) Création de la compagnie
        CompagnieAerienne compagnie = new CompagnieAerienne();

        // 2) Import des fichiers CSV avec les BONNES méthodes
        String base = "src/projet/compagnie/";
        compagnie.importerVolsDepuisFichier(base + "vols.csv");
        compagnie.importerAvionsDepuisFichier(base + "avions.csv");
        compagnie.importerPassagersDepuisFichier(base + "passagers.csv");
        compagnie.importerEmployesDepuisFichier(base + "employes.csv");

        // 3) Résumé des imports
        System.out.println("\n=== Résumé Import ===");
        System.out.println("Vols importés       : " + compagnie.getVols().size());
        System.out.println("Avions importés     : " + compagnie.getAvions().size());
        System.out.println("Passagers importés  : " + compagnie.getPassagers().size());
        System.out.println("Employés importés   : " + compagnie.getEmployes().size());

        // Si aucun vol n'a été importé, on s'arrête proprement
        if (compagnie.getVols().isEmpty()) {
            System.out.println("\nAucun vol importé, vérifie le fichier vols.csv et son chemin.");
            System.out.println("Process finished with exit code 0");
            return;
        }

        // ------------------------------------------------------------
        // 4) Tests des méthodes obligatoires
        // ------------------------------------------------------------

        // Premier vol
        Vol vol = compagnie.getVols().get(0);

        System.out.println("\n=== Infos Vol ===");
        System.out.println(vol.obtenirVol());

        // planifierVol()
        vol.planifierVol(999, "Paris", "Tokyo", new Date(), new Date());
        System.out.println("Vol après planification : " + vol.obtenirVol());

        // Avion
        if (!compagnie.getAvions().isEmpty()) {
            avions avion = compagnie.getAvions().get(0);
            System.out.println("\n=== Affectation Avion ===");
            avion.affecterVol(vol);
            System.out.println("Disponibilité avion après affectation : " + avion.verifierDisponibilite());
        }

        // Passager
        if (!compagnie.getPassagers().isEmpty()) {
            passagers p = compagnie.getPassagers().get(0);

            System.out.println("\n=== Réservation ===");
            Reservation r = p.reserverVol(vol);
            compagnie.ajouterReservation(r);

            System.out.println("Nombre de réservations du passager : " + p.obtenirReservations().size());
            System.out.println("Nombre total de réservations compagnie : "
                    + compagnie.getReservations().size());

            System.out.println("\n=== Annulation réservation ===");
            p.annulerReservation(r.getNumeroReservation());
            System.out.println("Réservations restantes : " + p.obtenirReservations().size());
        }

        System.out.println("\n=== Annulation du vol ===");
        vol.annulerVol();
        System.out.println("Le vol est-il annulé ? " + vol.estAnnule());

        System.out.println("\n=== FIN DES TESTS ===");
        System.out.println("Process finished with exit code 0");
    }
}
