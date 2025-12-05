package projet.compagnie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompagnieAerienne {

    private List<avions> avions = new ArrayList<>();
    private List<Vol> vols = new ArrayList<>();
    private List<passagers> passagers = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private List<employes> employes = new ArrayList<>();



    public void ajouterAvion(avions a) {
        avions.add(a);
    }

    public List<avions> getAvions() {
        return avions;
    }

    public void ajouterVol(Vol v) {
        vols.add(v);
    }

    public List<Vol> getVols() {
        return vols;
    }

    public void ajouterPassager(passagers p) {
        passagers.add(p);
    }

    public List<passagers> getPassagers() {
        return passagers;
    }

    public void ajouterReservation(Reservation r) {
        reservations.add(r);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void ajouterEmploye(employes e) {
        employes.add(e);
    }

    public List<employes> getEmployes() {
        return employes;
    }




    public void importerVolsDepuisFichier(String cheminFichier) {
        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {

            String ligne;

            while ((ligne = br.readLine()) != null) {
                if (ligne.trim().isEmpty()) continue;

                String[] morceaux = ligne.split(";");
                if (morceaux.length < 3) {
                    System.out.println("Ligne vols ignorée (mauvais format) : " + ligne);
                    continue;
                }

                int numeroVol = Integer.parseInt(morceaux[0]);
                String origine = morceaux[1];
                String destination = morceaux[2];

                Vol v = new Vol(numeroVol, origine, destination);
                ajouterVol(v);
            }

            System.out.println("Import des vols terminé.");

        } catch (IOException e) {
            System.out.println("Erreur de lecture fichier vols : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erreur numéro de vol (pas un entier) : " + e.getMessage());
        }
    }


    public void importerAvionsDepuisFichier(String cheminFichier) {
        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {

            String ligne;

            while ((ligne = br.readLine()) != null) {
                if (ligne.trim().isEmpty()) continue;

                String[] morceaux = ligne.split(";");
                if (morceaux.length < 3) {
                    System.out.println("Ligne avions ignorée (mauvais format) : " + ligne);
                    continue;
                }

                String immatriculation = morceaux[0];
                String modele = morceaux[1];
                int capacite = Integer.parseInt(morceaux[2]);

                avions a = new avions(immatriculation, modele, capacite);
                ajouterAvion(a);
            }

            System.out.println("Import des avions terminé.");

        } catch (IOException e) {
            System.out.println("Erreur de lecture fichier avions : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erreur de capacité avion (pas un entier) : " + e.getMessage());
        }
    }


    public void importerPassagersDepuisFichier(String cheminFichier) {
        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {

            String ligne;

            while ((ligne = br.readLine()) != null) {
                if (ligne.trim().isEmpty()) continue;

                String[] morceaux = ligne.split(";");
                if (morceaux.length < 4) {
                    System.out.println("Ligne passagers ignorée (mauvais format) : " + ligne);
                    continue;
                }

                int id = Integer.parseInt(morceaux[0]);
                String nom = morceaux[1];
                String adresse = morceaux[2];
                String contact = morceaux[3];

                passagers p = new passagers();
                p.identifiant = id;   // champs protégés -> même package
                p.nom = nom;
                p.adresse = adresse;
                p.contact = contact;

                ajouterPassager(p);
            }

            System.out.println("Import des passagers terminé.");

        } catch (IOException e) {
            System.out.println("Erreur de lecture fichier passagers : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erreur d'identifiant passager (pas un entier) : " + e.getMessage());
        }
    }


    public void importerEmployesDepuisFichier(String cheminFichier) {
        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {

            String ligne;

            while ((ligne = br.readLine()) != null) {
                if (ligne.trim().isEmpty()) continue;

                String[] morceaux = ligne.split(";");
                if (morceaux.length < 4) {
                    System.out.println("Ligne employes ignorée (mauvais format) : " + ligne);
                    continue;
                }

                int id = Integer.parseInt(morceaux[0]);
                String nom = morceaux[1];
                String adresse = morceaux[2];
                String contact = morceaux[3];

                employes e = new employes();
                e.identifiant = id;
                e.nom = nom;
                e.adresse = adresse;
                e.contact = contact;

                ajouterEmploye(e);
            }

            System.out.println("Import des employés terminé.");

        } catch (IOException e) {
            System.out.println("Erreur de lecture fichier employes : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erreur d'identifiant employé (pas un entier) : " + e.getMessage());
        }
    }
}
