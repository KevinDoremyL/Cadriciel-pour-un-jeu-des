//Classe context

public class Jeu extends Framework {

    Strategy strategy;
    
    public Jeu(IStrategie strategie,int nbTours) {
    }

    public void setStrategy(Stragegy param) {
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