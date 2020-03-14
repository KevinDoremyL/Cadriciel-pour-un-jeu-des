import java.util.ArrayList;

public class aPlateau {
    //

    public static void main(String[] args) {
        // TODO Vue de l'app ( M V C )

        BuncoStrategie strategie = new BuncoStrategie();
/*
        Jeu jeuTest = new Jeu(strategie);
        strategie.setJeuBunco();
        System.out.println("Kevin score final " + strategie.calculerScoreTour(jeuTest));
*/

        Jeu jeuTest = new Jeu(strategie);
        strategie.setJeuBunco();
        System.out.println("PartieNasim : ");

       System.out.println( "Score Final " + strategie.calculerScoreTourNassim(jeuTest));


    }
}