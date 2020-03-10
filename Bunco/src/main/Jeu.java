public class Jeu extends Framework {

    private Strategy strategy;
    
    public Jeu(Strategy strategie, int nbTours) {
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

    @Override
    void calculerLeVainceur() {

    }

    @Override
    void calculerScoreTour() {

    }
}