import java.util.ArrayList;

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
    public void setupGame() {
        for(int i=0; i<3; i++){
            collectionDes.ajouterDe(new De(6));
        }

    }

    @Override
    public void calculerLeVainqueur(Jeu jeu){

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


        int numeroTour = 1;

        int score=0;

        boolean actif = true; // pour plus tard pas maintenant

        Iterateur<Joueur> iterateurJoueur = jeu.getCollectionJoueur().getIterateur();

        do {
            rollDices();
            System.out.println("Numéro du tour : " + numeroTour );
            System.out.println("Dé Un : " + dePremier.getNuméroDé() + " Dé Deux : " + deDeuxieme.getNuméroDé() + " Dé Trois : " +deTroisieme.getNuméroDé() );
            /*
            Section pour faire les tests, exemple changer les valeurs des dés pour voir si l'algorithme marche
             */
            if (dePremier.getNuméroDé() == deDeuxieme.getNuméroDé() && dePremier.getNuméroDé() == deTroisieme.getNuméroDé()) { ;
                if (dePremier.getNuméroDé() == numeroTour )  {

                    score += 21;
                    iterateurJoueur.currentItem().setScore(score);
                    System.out.println(iterateurJoueur.currentItem().getNom() + " ScoreActuel BUNCO !!! : "+ iterateurJoueur.currentItem().getScore());
                    actif = false;

                } else {

                    score += 5;
                    iterateurJoueur.currentItem().setScore(score);
                    System.out.println(iterateurJoueur.currentItem().getNom() + " ScoreActuel "+ iterateurJoueur.currentItem().getScore());
                    numeroTour++;


                    actif = true;

                }
            }
            else  if (dePremier.getNuméroDé() != numeroTour && deDeuxieme.getNuméroDé() != numeroTour && deTroisieme.getNuméroDé() != numeroTour) {
                //iterateurJoueur.currentItem().setScore(0);
                score += 0;
                System.out.println(iterateurJoueur.currentItem().getNom() + " Score Actuel "+ iterateurJoueur.currentItem().getScore());
                numeroTour++;
                actif = false;
                // continuer ici lire en haut les contraintes et appliquer selon elles les différents if.
            }
            else {
                for (De de : this.collectionDes.getListeDes()
                ) {
                    if (de.getNuméroDé() == numeroTour) {
                        iterateurJoueur.currentItem().additionerScore(1);
                        score+=1;
                    }
                }
                iterateurJoueur.currentItem().setScore(score);
                System.out.println(iterateurJoueur.currentItem().getNom() + " ScoreActuel "+ iterateurJoueur.currentItem().getScore());
                actif = true;
                numeroTour++;


            }
        }
        while (numeroTour <= 6 && actif );


        return iterateurJoueur.currentItem().getScore();
    }



}

