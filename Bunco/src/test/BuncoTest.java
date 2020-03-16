import static org.junit.Assert.*;

import java.lang.reflect.Modifier;

import org.junit.Test;

public class BuncoTest {
    private static Class<BuncoStrategie> testClass;

    private BuncoStrategie testInstance = new BuncoStrategie();
    private CollectionJoueur collectionJoueur;

    @Test
    public void testClass() {
        assertEquals(Modifier.PUBLIC, testClass.getModifiers() & Modifier.PUBLIC);
        Class<?> ancestor = testClass.getSuperclass();
        assertNotNull(ancestor);

        boolean subjectIsAncestor = false;
        if (Strategy.class == ancestor) {
            subjectIsAncestor = true;
        } else {
            Class<?> secondDegreeAncestor = ancestor.getSuperclass();
            assertNotNull(secondDegreeAncestor);
            assertEquals(Strategy.class, secondDegreeAncestor);
        }

        if (!subjectIsAncestor) {
            fail("Strategy should be a superclass");
        }
    }

    @test
    public void setupGame_test() {
        CollectionDes collectionDes;
        BuncoStrategie buncoStrategie = new BuncoStrategie();
        buncoStrategie.setupGame();
        //
    }
}