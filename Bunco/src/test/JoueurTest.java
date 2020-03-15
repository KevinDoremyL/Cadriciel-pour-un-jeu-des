import static org.junit.Assert.*;

import java.lang.reflect.Modifier;

import org.junit.*;
import org.junit.internal.runners.TestClass;

public class JoueurTest {

    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueur3;
    private Joueur joueur4;
    private static Class<Joueur> testClass;

    @Before
    public void setUpBefore() {

        joueur1 = new Joueur("Junior", 6);
        joueur2 = new Joueur("Queen", 15);
        joueur3 = new Joueur("King", 21);
        joueur4 = new Joueur("King_v2", 21);

    }

    @Test
    public void testClass() {
        assertEquals(Modifier.PUBLIC, testClass.getModifiers() & Modifier.PUBLIC);
        Class<?> ancestor = testClass.getSuperclass();
        assertNull(ancestor);
    }

    @Test // test
    public void joueurScroreSuperieurTest() {

        assertTrue(joueur2.compareTo(joueur1) == 1);
    }

    @Test // test
    public void joueurScroreInferieurTest() {
        assertTrue(joueur2.compareTo(joueur3) == -1);
    }

    @Test // test
    public void joueurSameScroreTest() {
        assertTrue(joueur4.compareTo(joueur3) == 0);
    }

    @Test // test
    public void joueur_AjouteScore_Test() {
        joueur1.ajouterScore(22);
        // 22 points plus le score actuel de 6
        // le total est supposer faire 28
        assertTrue(joueur1.getScore() == 28);
    }

    @Test
    public void joueur_Constructor_String_Test() {
        Joueur joueurTest = new Joueur("Junior");
        assertEquals("Junior", joueurTest.getNom());

    }

    @Test
    public void joueur_Constructor_String_Int_Test() {
        assertEquals(new Joueur("Junior", 6), joueur1);
        assertEquals(new Joueur("Junior", 6), joueur1);
    }

}