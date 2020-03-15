import java.util.ArrayList;

public class aPlateau {
    //

    public static void main(String[] args) {
        // TODO Vue de l'app ( M V C )

        BuncoStrategie strategie = new BuncoStrategie();

        Jeu jeuTest = new Jeu(strategie);
        strategie.setJeuBunco();
        // System.out.println("Joueur Test " + strategie.calculerScoreTour(jeuTest));
        ArrayList<Joueur> listeJoueur  = strategie.calculerLeVainqueur(jeuTest);
        for (Joueur j:listeJoueur
        ) {
            System.out.println("Joueur : "+j.getNom() + " Score : " + j.getScore());
        }

    }
}