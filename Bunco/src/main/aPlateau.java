import java.util.ArrayList;

public class aPlateau {
    //

    public static void main(String[] args) {

        UserInterface.debutPartie();
        Jeu jeu = new Jeu();
        int choixStrategie = UserInterface.choixJeu();
        BuncoStrategie buncoStrategie = new BuncoStrategie();

        if(choixStrategie == 1){
            jeu.setStrategy(buncoStrategie);
        }

//        jeu.setStrategy(buncoStrategie); // temporaire, vrai version en haut
        jeu.getStrategy().setupGame();


        Joueur gagnant = jeu.getStrategy().calculerLeVainqueur(jeu);

        ArrayList<Joueur> listeJoueur = jeu.getCollectionJoueur().getListeJoueurs();

        for (Joueur j:listeJoueur) {
            System.out.println("Joueur : "+j.getNom() + " Score : " + j.getScore());
        }

        System.out.println("Gagnant : "+gagnant);

    }
}