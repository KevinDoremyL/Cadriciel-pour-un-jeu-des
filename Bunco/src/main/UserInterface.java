import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInterface {

    public UserInterface(){

    }

    public static void debutPartie(){

        System.out.println("----- Initialisation partie -----\n\n\n");
        System.out.println();
        int value = UserInterface.promptUserForInt();
        System.out.println(value);
    }

    public static int promptUserForInt(){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Entrez un chiffre: ");
       return Integer.parseInt(scanner.nextLine());
    }

}
