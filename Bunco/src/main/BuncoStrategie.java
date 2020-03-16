import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BuncoStrategie implements Strategy {

    private CollectionDes collectionDes = new CollectionDes(3);
    private int nbTour = 1;

    public void rollDices(){
        Iterateur<De> iterateur =  collectionDes.getIterateur();
        iterateur.currentItem().roll();
        while (iterateur.hasNext()) {
            iterateur.next().roll();
        }
    }


    @Override
    public void setupGame() {
        for(int i=0; i<3; i++){
            collectionDes.ajouterDe(Factory.getDice(6));
        }
    }

    @Override
    public Joueur calculerLeVainqueur(Jeu jeu){


        for (Joueur j: jeu.getCollectionJoueur().getListeJoueurs()) {
            System.out.println("\n\n-------- "+j.getNom()+" prend les dés ---------");
            j.setScore(calculerScoreTour(jeu));
        }

        Collections.sort(jeu.getCollectionJoueur().getListeJoueurs());

        return jeu.getCollectionJoueur().getListeJoueurs().get(0);

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

        boolean actif = true;

        for(int numeroTourJeu=1; numeroTourJeu<=6;numeroTourJeu++) {
            do {
                rollDices();
                System.out.println("\n Tour : " + numeroTourJeu);
                System.out.println("\tDé Un : " + dePremier.getNumeroDe() + " \tDé Deux : " + deDeuxieme.getNumeroDe() + " \tDé Trois : " + deTroisieme.getNumeroDe());

                if (dePremier.getNumeroDe() == deDeuxieme.getNumeroDe() && dePremier.getNumeroDe() == deTroisieme.getNumeroDe()) {

                    if (dePremier.getNumeroDe() == numeroTourJeu) {

                        score += 21;

                        System.out.println("\t\t\tScore actuel du joueur en cours BUNCO: " + score);

                        actif = false;

                    } else {

                        score += 5;

                        System.out.println("\t\t\tScore actuel du joueur en cours : " + score);

                        actif = true;

                    }
                } else if (dePremier.getNumeroDe() != numeroTourJeu && deDeuxieme.getNumeroDe() != numeroTourJeu && deTroisieme.getNumeroDe() != numeroTourJeu) {

                    score += 0;
                    System.out.println("\t\t\tScore actuel du joueur en cours : " + score);
                    actif = false;

                } else {
                    for (De de : this.collectionDes.getListeDes()) {
                        if (de.getNumeroDe() == numeroTourJeu) {

                            score += 1;
                        }
                    }
                    System.out.println("\t\t\tScore actuel du joueur en cours : " + score);
                    actif = true;


                }
            } while (actif );

        }
        return score;
    }



}

