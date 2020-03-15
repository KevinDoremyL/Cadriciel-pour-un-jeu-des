public class JeuTest {
    private static Class<Jeu> testClass;

    @Test
    public void testClass() {
        assertEquals(Modifier.PUBLIC, testClass.getModifiers() & Modifier.PUBLIC);
        Class<?> ancestor = testClass.getSuperclass();
        assertNotNull(ancestor);

        boolean subjectIsAncestor = false;
        if (Framework.class == ancestor) {
            subjectIsAncestor = true;
        } else {
            Class<?> secondDegreeAncestor = ancestor.getSuperclass();
            assertNotNull(secondDegreeAncestor);
            assertEquals(Framework.class, secondDegreeAncestor);
        }

        if (!subjectIsAncestor) {
            fail("Framework should be a superclass");
        }

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

    // TODO Test Unitaire 4 : Dans le cas où un joueur obtient trois chiffres
    // identiques et égaux au numéro du tour, le score calculé est 21 points et si
    // le joueur passe la main au joueur suivant.
}
