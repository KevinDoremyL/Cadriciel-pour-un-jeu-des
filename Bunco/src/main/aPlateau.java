import java.util.ArrayList;

public class aPlateau {
    //

    public static void main(String[] args) {
        // TODO Vue de l'app ( M V C )

        CollectionDes collectionDes = new CollectionDes(3);

        collectionDes.ajouterDe(new De(6));

        collectionDes.ajouterDe(new De(6));

        collectionDes.ajouterDe(new De(6));

        De dePremier = collectionDes.getListeDes().get(0);

        De deDeuxieme = collectionDes.getListeDes().get(1);

        De deTroisieme= collectionDes.getListeDes().get(2);

        //  while actif le tour actif tu continues à calculker

        int nbTour = 0;

        int nbTourMax=6;

        int score = 0;

        dePremier.roll();

        deDeuxieme.roll();

        deTroisieme.roll();

        System.out.println(dePremier.getNbFaces());

        /*
        while(nbTour <= 6){

            if(dePremier.getNbFaces()
                    != nbTourMax && deDeuxieme.getNbFaces() !=nbTourMax && deTroisieme.getNbFaces() !=nbTourMax){

                nbTour++;

                dePremier.roll();

                System.out.println(dePremier);
            }

        }
           // System.out.println(collectionDes.getListeDes().get(0).getNbFaces());

         */
        int i = 1;
        do {
            System.out.println(i);
            i++;
        }
        while (i <= 6);
        }

    public static void rollDices(CollectionDes collectionDes){
        Iterateur<De> iterateur =  collectionDes.getIterateur();
        iterateur.currentItem().roll();
        while (iterateur.hasNext()) {
            iterateur.next().roll();
        }
    }
}
