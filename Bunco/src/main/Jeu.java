public class Jeu extends Framework {

    private CollectionJoueur collectionJoueur;
    private Strategy strategy;
    
    public Jeu() {
    }

    public Strategy getStrategy(){
        return this.strategy;
    }

    public Jeu(Strategy strategie) {
        this.strategy = strategie;
        this.collectionJoueur = new CollectionJoueur(3);
        Joueur Kevin = new Joueur("Kevin");
        Joueur nassim = new Joueur("Nassim");
        Joueur ryad = new Joueur("Ryad");
        Joueur camile = new Joueur("Camile");
        this.collectionJoueur.ajouterJoueur(Kevin);
        this.collectionJoueur.ajouterJoueur(nassim);
        this.collectionJoueur.ajouterJoueur(ryad);
        this.collectionJoueur.ajouterJoueur(camile);

    }

    public void setStrategy(Strategy param) {
        this.strategy = param;
    }

    public void setNbJoueur(int nbJoueur) {
        this.collectionJoueur = new CollectionJoueur(nbJoueur);
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