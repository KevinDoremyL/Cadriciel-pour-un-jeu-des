import java.util.ArrayList;

public class BuncoStrategie implements Strategy {
    private CollectionDes collectionDes = new CollectionDes(3);
    private int nbTour = 1;

    public void setJeuBunco() {

        this.collectionDes.setFaceDesDes(6);

    }


    public void jouerUnTour(){
      Iterateur<De> iterateur =  collectionDes.getIterateur();
      iterateur.currentItem().roll();
        while (iterateur.hasNext()) {
            iterateur.next().roll();
        }

    }
    @Override
    public void calculerLeVainqueur(Jeu jeu){

    }
    @Override
    public void calculerScoreTour(Jeu jeu) {

    Iterateur<Joueur> iterateurJoueur = jeu.getCollectionJoueur().getIterateur();
    jouerUnTour();
    int identiqueAuTour =0;


    while(this.nbTour <= 6 && iterateurJoueur.currentItem().getScore() < 21 &&
            iterateurJoueur.currentItem().getScore()!=0
            && iterateurJoueur.hasNext()){

            jouerUnTour();



        this.nbTour++;
    }
    iterateurJoueur.next();




    }



}