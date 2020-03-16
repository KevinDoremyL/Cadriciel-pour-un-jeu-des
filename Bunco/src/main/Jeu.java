public class Jeu extends GameTemplate {

    private CollectionJoueur collectionJoueur;
    private Strategy strategy;
    
    public Jeu() {
//        this.collectionJoueur = new CollectionJoueur(3);
//        Joueur Kevin = new Joueur("Kevin");
//        Joueur nassim = new Joueur("Nassim");
//        Joueur ryad = new Joueur("Ryad");
//        Joueur camile = new Joueur("Camile");
//        this.collectionJoueur.ajouterJoueur(Kevin);
//        this.collectionJoueur.ajouterJoueur(nassim);
//        this.collectionJoueur.ajouterJoueur(ryad);
//        this.collectionJoueur.ajouterJoueur(camile);
        this.collectionJoueur = UserInterface.peuplerJoueurs();
    }

    public Strategy getStrategy(){
        return this.strategy;
    }

    public void setStrategy(Strategy param) {
        this.strategy = param;
    }

    public CollectionJoueur getCollectionJoueur() {
        return collectionJoueur;
    }

    @Override
    public Joueur calculerLeVainqueur(Jeu jeu) {
        return strategy.calculerLeVainqueur(this);
    }

}