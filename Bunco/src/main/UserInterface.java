import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    public UserInterface(){

    }

    public static void debutPartie(){

        System.out.println("----- Initialisation partie -----");
        int choixJeu = choixJeu();

    }

    public static int choixJeu(){

        System.out.println("Veuillez choisir un jeu : ");
        System.out.println("1 - Bunco");
        System.out.println("2 - Autre futur jeu\n");
        return UserInterface.promptUserForInt();
    }

    public static ArrayList<Joueur> peuplerJoueurs(){

        System.out.println("Choissisez le nombre de joueur: ");
        int nombreDeJoueur = promptUserForInt();

        CollectionJoueur joueurs = new CollectionJoueur(nombreDeJoueur);
        int joueurCreer = 0;
        String nom = "";
        while(joueurCreer <= nombreDeJoueur){

        }

    }

    public static int promptUserForInt(){
        int value = 0;
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        while(value == 0) {
            System.out.println("Entrez un chiffre: ");

            try {
                value = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide");
            }
        }
        return value;
    }

    public static String promptUserForName(){
        String name = "";
        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        while(name.isEmpty()) {
            System.out.println("Entrez un nom: ");
            name = scanner.nextLine();
        }
        return name;
    }


    public static void montrerGagnant(ArrayList<Joueur> tableJoueur){
        System.out.println("-- Tableau de pointage --");

        for ( Joueur j : tableJoueur){
            System.out.println(j.getNom()+"\t : "+j.getScore());
        }

    }

}
