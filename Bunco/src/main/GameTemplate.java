public abstract class GameTemplate {


    public abstract void setStrategy(Strategy s);

    public abstract Joueur calculerLeVainqueur(Jeu jeu);

    public void afficherGagnant(Joueur joueur){
        System.out.println("\n\tLe gagnant est "+joueur.getNom()+" bravo !!!!");
    }

    public void afficherScore(CollectionJoueur collectionJoueur){
        UserInterface.montrerGagnant(collectionJoueur.getListeJoueurs());
    }

}