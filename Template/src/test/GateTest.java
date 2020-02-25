import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Modifier;

public class GateTest {
  public GateTest() {
    super();
  }

  static class GateObserver extends Observer {
    private boolean updateCalled = false;

    public boolean getUpdateCalled() {
      return updateCalled;
    }

    public void update() {
      updateCalled = true;
    }
  }

  private static Class<Gate> testClass;
  private Gate testInstance;

  private static Flight flight1;
  private static Flight flight2;

  @Before
  public void setUpBefore() {
    testClass = Gate.class;
    testInstance = new Gate("B-5");

    flight1 = new Flight("BC", 135, "Vancouver", 1710, "C-2", Flight.ONTIME);
    flight2 = new Flight("AM", 560, "Buenos Aires", 1450, "B-5", Flight.ONTIME);

  }

  @Test
  public void testClass() {
    assertEquals(Modifier.PUBLIC, testClass.getModifiers() & Modifier.PUBLIC);

    Class<?> ancestor = testClass.getSuperclass();
    assertNotNull(ancestor);

    boolean subjectIsAncestor = false;
    if (Subject.class == ancestor) {
      subjectIsAncestor = true;
    } else {
      Class<?> secondDegreeAncestor = ancestor.getSuperclass();
      assertNotNull(secondDegreeAncestor);
      assertEquals(Subject.class, secondDegreeAncestor);
    }

    if (!subjectIsAncestor) {
      fail("Subject should be a superclass");
    }
  }

  @Test
  public void testAddFligh() {
    testInstance.addFlight(flight1);
  }

  @Test
  public void testRemoveFlight() {
    testInstance.addFlight(flight1);
    testInstance.removeFlight(flight1);
    testInstance.removeFlight(flight2);
  }

  @Test
  public void testGetFlights() {
    List<Flight> flights = testInstance.getFlights();
    assertEquals(0, flights.size());

    testInstance.addFlight(flight1);

    flights = testInstance.getFlights();
    assertEquals(1, flights.size());
    assertEquals(flight1, flights.get(0));
  }

  @Test
  public void testNotifyObserversAdd() {
    GateObserver observer = new GateObserver();
    testInstance.attach(observer);
    testInstance.addFlight(flight1);
    assertTrue(observer.getUpdateCalled());
  }

  @Test
  public void testNotifyObserversRemove() {
    GateObserver observer = new GateObserver();
    testInstance.addFlight(flight1);
    testInstance.attach(observer);
    testInstance.removeFlight(flight1);
    assertTrue(observer.getUpdateCalled());
  }

}
