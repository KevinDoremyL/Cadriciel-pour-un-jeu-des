import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BuncoStrategie implements Strategy {
    private CollectionDes collectionDes = new CollectionDes(3);
    private int nbTour = 1;

    public void setJeuBunco() {
        for(int i=0; i<3; i++){
            collectionDes.ajouterDe(new De(6));
        }

    }


    public void rollDices(){
      Iterateur<De> iterateur =  collectionDes.getIterateur();
      iterateur.currentItem().roll();
        while (iterateur.hasNext()) {
            iterateur.next().roll();
        }
    }



    @Override
    public ArrayList<Joueur> calculerLeVainqueur(Jeu jeu){


        ArrayList ListeJoueurQuiJoue = new ArrayList<>();

        for (Joueur j: jeu.getCollectionJoueur().getListeJoueurs()
        ) {

           j.setScore(calculerScoreTour(jeu));
        }

        Collections.sort(jeu.getCollectionJoueur().getListeJoueurs(), new Comparator<Joueur>() {
            @Override
            public int compare(Joueur j1, Joueur j2) {
                return  j2.getScore() - j1.getScore();
            }
        });

        return jeu.getCollectionJoueur().getListeJoueurs();





    }



    @Override
    public int calculerScoreTour(Jeu jeu) {
        /***
         * Dans le cas où un joueur obtient trois chiffres identiques et égaux au numéro du tour, le score calculé est 21 points et si le joueur passe la main au joueur suivant.
         * Dans le cas d'obtention de 3 chiffres identiques mais différents du numéro de tour si le score est de 5 points et le joueur garde la main.
         * Dans le cas d'obtention d'un seul chiffre correspondant au numéro de tour si le score est correct et si le joueur garde la main.
         * Dans le cas d'obtention de 0 point si le joueur passe la main au joueur suivant.
         * Le classement final des joueurs avec différents scores.
         */
        // boolean qui dit si tu retournes ou non
        De dePremier = this.collectionDes.getListeDes().get(0);
        De deDeuxieme = this.collectionDes.getListeDes().get(1);
        De deTroisieme = this.collectionDes.getListeDes().get(2);

        int score=0;

        boolean actif = true; // pour plus tard pas maintenant


        for(int numeroTourJeu=1; numeroTourJeu<=6;numeroTourJeu++) {
            do {
                rollDices();
                System.out.println("Numéro du tour : " + numeroTourJeu);
                System.out.println("Dé Un : " + dePremier.getNuméroDé() + " Dé Deux : " + deDeuxieme.getNuméroDé() + " Dé Trois : " + deTroisieme.getNuméroDé());

                if (dePremier.getNuméroDé() == deDeuxieme.getNuméroDé() && dePremier.getNuméroDé() == deTroisieme.getNuméroDé()) {
                    ;
                    if (dePremier.getNuméroDé() == numeroTourJeu) {

                        score += 21;

                        System.out.println("Joueur Test" + " ScoreActuel BUNCO !!! : " + score);

                        actif = false;

                    } else {

                        score += 5;

                        System.out.println("Joueur Test" + " ScoreActuel : " + score);



                        actif = true;

                    }
                } else if (dePremier.getNuméroDé() != numeroTourJeu && deDeuxieme.getNuméroDé() != numeroTourJeu && deTroisieme.getNuméroDé() != numeroTourJeu) {

                    score += 0;
                    System.out.println("Joueur Test" + " ScoreActuel : " + score);
                    actif = false;

                } else {
                    for (De de : this.collectionDes.getListeDes()
                    ) {
                        if (de.getNuméroDé() == numeroTourJeu) {

                            score += 1;
                        }
                    }
                    System.out.println("Joueur Test" + " ScoreActuel : " + score);
                    actif = true;



                }
            }
            while (actif);

        }
        return score;
    }



}

