//Classe context

public class Jeu extends Framework {

    private Strategy strategy;
    
    public Jeu(Strategy strategie,int nbTours) {
    }

    public void setStrategy(Strategy param) {
        this.strategy = param;
    }

    public void executeScore() {

    }

    public void executeVainceur() {

    }

    @Override
    public void calculerLeVainqueur(Jeu jeu) {
        strategy.calculerLeVainqueur(jeu);

    }

    @Override
    public void calculerScoreTour(Jeu jeu) {
        strategy.calculerScoreTour(jeu);

    }

}