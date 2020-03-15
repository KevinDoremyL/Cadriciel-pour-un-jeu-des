public class Jeu extends Framework {



    private CollectionJoueur collectionJoueur;
    private Strategy strategy;
    private int nbJoueur;
    private  int nbTour= 6;

    public int getNbTour() {
        return nbTour;
    }

    public Jeu(Strategy strategie, int nbJoueur) {
        this.strategy = strategie;
        this.collectionJoueur = new CollectionJoueur(nbJoueur);
        this.nbJoueur = nbJoueur;
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
    public Jeu(Strategy strategie,  int nbJoueur,int nbTour) {
        this.strategy = strategie;
        this.collectionJoueur = new CollectionJoueur(3);
        this.nbTour = nbTour;
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