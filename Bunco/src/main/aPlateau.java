import java.util.ArrayList;

public class aPlateau {
    //

    public static void main(String[] args) {
        // TODO Vue de l'app ( M V C )

        UserInterface.debutPartie();
        int choixStrategie = UserInterface.choixJeu();

        BuncoStrategie buncoStrategie = new BuncoStrategie();

        if(choixStrategie == 1){
            Jeu jeuBunco = new Jeu(buncoStrategie);
        }


        buncoStrategie.setupGame();
        Joueur gagnant = buncoStrategie.calculerLeVainqueur(jeuBunco);

        ArrayList<Joueur> listeJoueur = jeuBunco.getCollectionJoueur().getListeJoueurs();

        for (Joueur j:listeJoueur) {
            System.out.println("Joueur : "+j.getNom() + " Score : " + j.getScore());
        }

        System.out.println("Gagnant : "+gagnant);

    }
}