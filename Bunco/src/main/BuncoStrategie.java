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
    public int calculerPointage() {
        int scoreSelonBrassage = 0;
        rollDices();
        int dePremier = this.collectionDes.getListeDes().get(0).getNbFaces();
        int deDeuxieme = this.collectionDes.getListeDes().get(1).getNbFaces();
        int deTroisieme= this.collectionDes.getListeDes().get(2).getNbFaces();

        if (dePremier== deDeuxieme && dePremier == deTroisieme) {

            if (dePremier == this.nbTour) {
                scoreSelonBrassage = 21;
            } else {
                scoreSelonBrassage = 5;
            }
        }
        else {
            for (De de : this.collectionDes.getListeDes()
            ) {
                if (de.getNbFaces() == nbTour) {
                    scoreSelonBrassage++;
                }
            }
        }

        return  scoreSelonBrassage;
    }
    public int methodeTest(Jeu jeu){
        /***
         * Dans le cas où un joueur obtient trois chiffres identiques et égaux au numéro du tour, le score calculé est 21 points et si le joueur passe la main au joueur suivant.
         * Dans le cas d'obtention de 3 chiffres identiques mais différents du numéro de tour si le score est de 5 points et le joueur garde la main.
         * Dans le cas d'obtention d'un seul chiffre correspondant au numéro de tour si le score est correct et si le joueur garde la main.
         * Dans le cas d'obtention de 0 point si le joueur passe la main au joueur suivant.
         * Le classement final des joueurs avec différents scores.
         */
        Iterateur<Joueur> iterateurJoueur = jeu.getCollectionJoueur().getIterateur();
        rollDices();

        while(this.nbTour <= 6 && iterateurJoueur.currentItem().getScore() < 21 &&
                iterateurJoueur.currentItem().getScore()!=0
                && iterateurJoueur.hasNext()){

            int scoreSelonBrassage = 0;
            rollDices();
            int dePremier = this.collectionDes.getListeDes().get(0).getNbFaces();
            int deDeuxieme = this.collectionDes.getListeDes().get(1).getNbFaces();
            int deTroisieme= this.collectionDes.getListeDes().get(2).getNbFaces();

            //  Dans le cas d'obtention de 0 point si le joueur passe la main au joueur suivant.
            if(dePremier != nbTour && deDeuxieme !=nbTour && deTroisieme !=nbTour){

                iterateurJoueur.currentItem().setScore(0);
                iterateurJoueur.next();
                nbTour=1;
                rollDices();
                // continuer ici lire en haut les contraintes et appliquer selon elles les différents if.
            }
            else if (dePremier== deDeuxieme && dePremier == deTroisieme) {

                if (dePremier == this.nbTour) {
                    iterateurJoueur.currentItem().setScore(21);
                    iterateurJoueur.next();
                } else {
                    iterateurJoueur.currentItem().setScore(21);
                    nbTour++;
                    rollDices();
                }
            }
            else{
                int pareille=0;
                for (De de : this.collectionDes.getListeDes()
                ) {
                    if (de.getNbFaces() == nbTour) {
                        iterateurJoueur.currentItem().additionerScore(1);
                    }
                }

                nbTour++;
                rollDices();

            }



        }
        iterateurJoueur.next();
        return 0;
    }
    @Override
    public void calculerLeVainqueur(Jeu jeu){

    }


    public void calculerScoreTour1(Jeu jeu) {


        /***
         * Dans le cas où un joueur obtient trois chiffres identiques et égaux au numéro du tour, le score calculé est 21 points et si le joueur passe la main au joueur suivant.
         * Dans le cas d'obtention de 3 chiffres identiques mais différents du numéro de tour si le score est de 5 points et le joueur garde la main.
         * Dans le cas d'obtention d'un seul chiffre correspondant au numéro de tour si le score est correct et si le joueur garde la main.
         * Dans le cas d'obtention de 0 point si le joueur passe la main au joueur suivant.
         * Le classement final des joueurs avec différents scores.
         */
        Iterateur<Joueur> iterateurJoueur = jeu.getCollectionJoueur().getIterateur();
        rollDices();

    while(this.nbTour <= 6 && iterateurJoueur.currentItem().getScore() < 21 &&
            iterateurJoueur.currentItem().getScore()!=0
            && iterateurJoueur.hasNext()){

        int scoreSelonBrassage = 0;
        rollDices();
        int dePremier = this.collectionDes.getListeDes().get(0).getNbFaces();
        int deDeuxieme = this.collectionDes.getListeDes().get(1).getNbFaces();
        int deTroisieme= this.collectionDes.getListeDes().get(2).getNbFaces();

        //  Dans le cas d'obtention de 0 point si le joueur passe la main au joueur suivant.
        if(dePremier != nbTour && deDeuxieme !=nbTour && deTroisieme !=nbTour){

            iterateurJoueur.currentItem().setScore(0);
            iterateurJoueur.next();
            nbTour=1;
            rollDices();
        // continuer ici lire en haut les contraintes et appliquer selon elles les différents if.
        }
        else if (dePremier== deDeuxieme && dePremier == deTroisieme) {

            if (dePremier == this.nbTour) {
                iterateurJoueur.currentItem().setScore(21);
                iterateurJoueur.next();
            } else {
                iterateurJoueur.currentItem().setScore(21);
                nbTour++;
                rollDices();
            }
        }
        else{
            int pareille=0;
            for (De de : this.collectionDes.getListeDes()
            ) {
                if (de.getNbFaces() == nbTour) {
                    iterateurJoueur.currentItem().additionerScore(1);
                }
            }

            nbTour++;
            rollDices();

        }



    }
    iterateurJoueur.next();




    }
    @Override
    public void calculerScoreTour(Jeu jeu) {


        /***
         * Dans le cas où un joueur obtient trois chiffres identiques et égaux au numéro du tour, le score calculé est 21 points et si le joueur passe la main au joueur suivant.
         * Dans le cas d'obtention de 3 chiffres identiques mais différents du numéro de tour si le score est de 5 points et le joueur garde la main.
         * Dans le cas d'obtention d'un seul chiffre correspondant au numéro de tour si le score est correct et si le joueur garde la main.
         * Dans le cas d'obtention de 0 point si le joueur passe la main au joueur suivant.
         * Le classement final des joueurs avec différents scores.
         */
        Iterateur<Joueur> iterateurJoueur = jeu.getCollectionJoueur().getIterateur();
        rollDices();

        while(this.nbTour <= 6 && iterateurJoueur.currentItem().getScore() < 21 &&
                iterateurJoueur.currentItem().getScore()!=0
                && iterateurJoueur.hasNext()){

            int scoreSelonBrassage = 0;
            rollDices();
            int dePremier = this.collectionDes.getListeDes().get(0).getNbFaces();
            int deDeuxieme = this.collectionDes.getListeDes().get(1).getNbFaces();
            int deTroisieme= this.collectionDes.getListeDes().get(2).getNbFaces();

            //  Dans le cas d'obtention de 0 point si le joueur passe la main au joueur suivant.
            if(dePremier != nbTour && deDeuxieme !=nbTour && deTroisieme !=nbTour){

                iterateurJoueur.currentItem().setScore(0);
                iterateurJoueur.next();
                nbTour=1;
                rollDices();
                // continuer ici lire en haut les contraintes et appliquer selon elles les différents if.
            }
            else if (dePremier== deDeuxieme && dePremier == deTroisieme) {

                if (dePremier == this.nbTour) {
                    iterateurJoueur.currentItem().setScore(21);
                    iterateurJoueur.next();
                } else {
                    iterateurJoueur.currentItem().setScore(21);
                    nbTour++;
                    rollDices();
                }
            }
            else{
                int pareille=0;
                for (De de : this.collectionDes.getListeDes()
                ) {
                    if (de.getNbFaces() == nbTour) {
                        iterateurJoueur.currentItem().additionerScore(1);
                    }
                }

                nbTour++;
                rollDices();

            }



        }
        iterateurJoueur.next();




    }


}