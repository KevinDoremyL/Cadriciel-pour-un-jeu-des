public class MainPlateau {
    //

    public static void main(String[] args) {

        UserInterface.debutPartie();

        Jeu jeu = Factory.getJeu();

        int choixStrategie = -1;

        while(choixStrategie == -1) {
            choixStrategie = UserInterface.choixJeu();
            if (choixStrategie == 1) {
                BuncoStrategie buncoStrategie = new BuncoStrategie();
                jeu.setStrategy(buncoStrategie);
            } else {
                System.out.println("Désolé, il y a seulement Bunco pour l'instant. Ce jeu vous sera imposé.");
                choixStrategie = -1;
            }
        }

        jeu.getStrategy().setupGame();

        Joueur gagnant = jeu.calculerLeVainqueur(jeu);

        jeu.afficherScore(jeu.getCollectionJoueur());

        jeu.afficherGagnant(gagnant);

    }
}