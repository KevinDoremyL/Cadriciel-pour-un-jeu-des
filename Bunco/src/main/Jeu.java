public class Jeu extends Framework {

    private Strategy strategy;
    private int nbTours;
    private CollectionDes listeDes;
    private CollectionJoueur listeJoueurs;
    
    public Jeu(Strategy strategie,  int nbJoueurs) {


        this.nbTours = nbTours;

        listeJoueurs = new CollectionJoueur(nbJoueurs);

    }

    public void setStrategy(Strategy param) {
        this.strategy = param;
    }

    public void executeScore(Jeu jeu) {
        strategy.calculerScoreTour(jeu);
    }

    public void executeVainceur(Jeu jeu) {
        strategy.calculerLeVainqueur(jeu);
    }

    public int getNbTours() {
        return nbTours;
    }

    @Override
    void calculerLeVainceur() {

    }

    @Override
    void calculerScoreTour() {

    }
}