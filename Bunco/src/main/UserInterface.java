import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInterface {

    public UserInterface(){

    }

    public static void debutPartie(){

        System.out.println("----- Initialisation partie -----");
        System.out.println("Veuillez choisir un jeu : ");
        System.out.println("1 - Bunco");
        System.out.println("2 - Autre future jeu\n");
        int value = UserInterface.promptUserForInt();
        System.out.println(value);
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

}
