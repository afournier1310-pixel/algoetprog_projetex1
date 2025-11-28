import projet.compagnie.*;

public class Main {
    public static void main(String[] args) {

        // Création d’objets pour tester les classes
        Personne p = new Personne();
        employes e = new employes();
        pilotes pil = new pilotes();
        personnelcabine pc = new personnelcabine();
        passagers pa = new passagers();
        avions av = new avions();
        Vol vol = new Vol();
        Reservation r = new Reservation();
        aeroport ap = new aeroport();

        // Si on arrive à cet affichage, c’est que TOUT compile bien
        System.out.println("✔ Toutes les classes compilent correctement !");
    }
}
