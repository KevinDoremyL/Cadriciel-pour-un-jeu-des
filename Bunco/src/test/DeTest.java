import static org.junit.Assert.assertTrue;

import org.junit.*;

//Try
public class DeTest {

	private De de1;
	private De de2;

	@Before
	public void faireAvant() {
		de1 = new De(6);
		de2 = new De(6);
	}

	@Test
	public void deSuperieurTest() {
		de1.setFaceObtenue(4);
		de2.setFaceObtenue(5);
		assertTrue(de1.compareTo(de2) == 1);
	}

	@Test //test 
	public void deInferieurTest() {
		de1.setFaceObtenue(4);
		de2.setFaceObtenue(5);
		assertTrue(de2.compareTo(de1) == -1);
	}

	@Test // Ceci est un deuxieme test
	public void memeDeTest() {
		de1.setFaceObtenue(4);
		assertTrue(de1.compareTo(de1) == 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deNullTest() {
		de1.setFaceObtenue(4);
		de1.compareTo(null);
	}
}