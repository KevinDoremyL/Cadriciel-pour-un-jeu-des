public interface Strategy {

    public void setupGame();

    public Joueur calculerLeVainqueur(Jeu jeu);

    public int calculerScoreTour(Jeu jeu);

}


