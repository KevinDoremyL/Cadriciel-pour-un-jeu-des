import static org.junit.Assert.*;

import java.lang.reflect.Modifier;

import org.junit.Test;

public class JeuTest {
    private static Class<Jeu> testClass;

    private Jeu testInstance = new Jeu();
    private CollectionJoueur collectionJoueur;

    @Test
    public void testClass() {
        assertEquals(Modifier.PUBLIC, testClass.getModifiers() & Modifier.PUBLIC);
        Class<?> ancestor = testClass.getSuperclass();
        assertNotNull(ancestor);

        boolean subjectIsAncestor = false;
        if (GameTemplate.class == ancestor) {
            subjectIsAncestor = true;
        } else {
            Class<?> secondDegreeAncestor = ancestor.getSuperclass();
            assertNotNull(secondDegreeAncestor);
            assertEquals(GameTemplate.class, secondDegreeAncestor);
        }

        if (!subjectIsAncestor) {
            fail("GameTemplate should be a superclass");
        }
    }

    @Before
    public void faireAvant() {

        testInstance.setStrategy(new BuncoStrategie());
        testInstance.getStrategy().setupGame();
        collectionJoueur = new CollectionJoueur(3);

        Joueur Kevin = new Joueur("Kevin");
        Joueur nassim = new Joueur("Nassim");
        Joueur ryad = new Joueur("Ryad");
        Joueur camile = new Joueur("Camile");
        this.collectionJoueur.ajouterJoueur(Kevin);
        this.collectionJoueur.ajouterJoueur(nassim);
        this.collectionJoueur.ajouterJoueur(ryad);
        this.collectionJoueur.ajouterJoueur(camile);

        testInstance.setCollectionJoueur(collectionJoueur);

    }

    @Test
    public void classement_final_des_joueurs_Class() {
        //Création de deux instantes de Bunco
        BuncoStrategie testInstanteBunco = new BuncoStrategie();
        BuncoStrategie testInstanteBunco2 = new BuncoStrategie();
testInstanteBunco.calculerLeVainqueur(testInstance);
testInstanteBunco2.calculerLeVainqueur(testInstance);
        // Si les deux instances donnent le même resultat (il y une erreur)
if (assertNotEquals(testInstanteBunco, testInstanteBunco2)) {
} else {
fail("Le resultat reste le même... Erreur  ")
}
        

        testInstanteBunco.calculerLeVainqueur(testInstance);
        

    }

    @Test
    public void obtenir_3_des_identiques_tour_differents() {

    }

    // TODO Test Unitaire 1 : Le classement final des joueurs avec différents
    // scores.
    // TODO Test Unitaire 4 : Dans le cas d'obtention de 3 chiffres identiques mais
    // différents du numéro de tour si le score est de 5 points et le joueur garde
    // la main.

    // TODO Test Unitaire 2 : Dans le cas d'obtention de 0 point si le joueur passe
    // la main au joueur suivant

    // TODO Test Unitaire 3 : Dans le cas d'obtention d'un seul chiffre
    // correspondant au numéro de tour si le score est correct et si le joueur garde
    // la main.

    // TODO Test Unitaire 5 : Dans le cas où un joueur obtient trois chiffres
    // identiques et égaux au numéro du tour, le score calculé est 21 points et si
    // le joueur passe la main au joueur suivant.
}
