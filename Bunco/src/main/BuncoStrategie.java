public class BuncoStrategie implements Strategy {

    CollectionDes listeDeBunco;
    Iterateur<De> iterateur = listeDeBunco.getIterateur();

    @Override
    public void setupGame() {
        listeDeBunco = new CollectionDes(3);

        for (De deBunco : listeDeBunco.getListeDes()) {
            listeDeBunco.ajoutDe(deBunco);
            deBunco.setFaceObtenue(6);
        }
    }

    @Override
    public void calculerLeVainqueur(Jeu jeu) {}

    @Override
    public int calculerScoreTour(Jeu jeu) {

        int score = 0;
        int nbPareil = 0;

        for (int tour = 1; tour <= jeu.getNbTours(); tour++) {

            while (iterateur.hasNext()) {
                if (iterateur.currentItem().getNbFaces() == tour) {
                    nbPareil++;
                }
                if (nbPareil == 3 && iterateur.currentItem().getNbFaces() != tour) {
                    nbPareil = 4;
                }
                iterateur.next();
            }

            if (nbPareil == 1) {
                score++;
            }

            if (nbPareil == 2) {
                score += 2;
            }

            if (nbPareil == 3) {
                score += 21;
                return score;
            }

            if (nbPareil == 4) {
                score += 5;
            }

            if (nbPareil == 0) {
                return score;
            }

        }

        return score;
    }
}