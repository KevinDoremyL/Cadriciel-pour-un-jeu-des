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
        } else {
            System.out.println("Désolé, il y a seulement Bunco pour l'instant. Ce jeu vous sera imposé.");
            jeu.setStrategy(buncoStrategie);
        }

        jeu.getStrategy().setupGame();

        Joueur gagnant = jeu.calculerLeVainceur(jeu);

        ArrayList<Joueur> listeJoueur = jeu.getCollectionJoueur().getListeJoueurs();

        for (Joueur j:listeJoueur) {
            System.out.println("Joueur : "+j.getNom() + " Score : " + j.getScore());
        }

        System.out.println("Gagnant : "+gagnant);

    }
}