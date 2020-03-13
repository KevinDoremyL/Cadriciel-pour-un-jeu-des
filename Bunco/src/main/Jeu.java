public class Jeu extends Framework {

    private CollectionJoueur collectionJoueur;
    private Strategy strategy;
    
    public Jeu(Strategy strategie,int nbJoueur) {
        this.strategy = strategie;
        this.collectionJoueur = new CollectionJoueur(nbJoueur);
        
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



    public void setCollectionJoueur(CollectionJoueur collectionJoueur) {
        this.collectionJoueur = collectionJoueur;
    }

    public CollectionJoueur getCollectionJoueur() {
        return collectionJoueur;
    }

    @Override
    void calculerLeVainceur() {

    }

    @Override
    void calculerScoreTour() {

    }
}