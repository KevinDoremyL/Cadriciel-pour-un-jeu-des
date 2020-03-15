import java.util.ArrayList;
import java.util.Collections;

public class main {
    
    public static void main(String[] args) {

        // UserInterface.debutPartie();
        ArrayList<Joueur> tab = new ArrayList<Joueur>();

        Joueur Kevin = new Joueur("Kevin",5);
        Joueur nassim = new Joueur("Nassim",8);
        Joueur ryad = new Joueur("Ryad",1);
        Joueur camile = new Joueur("Camile",67);

        tab.add(Kevin);
        tab.add(camile);
        tab.add(nassim);
        tab.add(ryad);

        Collections.sort(tab);

        UserInterface.montrerGagnant(tab);
    }
}
