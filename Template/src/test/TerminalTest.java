
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Modifier;

public class TerminalTest {
  public TerminalTest() {
    super();
  }

  static class TerminalObserver extends Observer {

    private boolean updateCalled = false;

    public boolean getUpdateCalled() {
      return updateCalled;
    }

    public void update() {
      updateCalled = true;
    }
  }

  private static Class<Terminal> testClass;
  private Terminal testInstance;

  private static Flight flight1;
  private static Flight flight2;
  private static Flight flight3;

  @Before
  public void setUpBefore() {
    testClass = Terminal.class;
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
  public void testAddFlight() {
    testInstance.addFlight(flight1);
    testInstance.addFlight(flight2);
    testInstance.addFlight(flight3);
  }

  @Test
  public void testRemoveFlight() {
    testInstance.addFlight(flight1);
    testInstance.removeFlight(flight1);
    testInstance.removeFlight(flight2);
  }

  @Test
  public void testGetFlights() {
    testInstance.addFlight(flight1);
    testInstance.addFlight(flight2);
    testInstance.addFlight(flight3);

    List<Flight> flights = testInstance.getFlights();
    assertEquals(3, flights.size());
    assertEquals(flight1, flights.get(0));
    assertEquals(flight2, flights.get(1));
    assertEquals(flight3, flights.get(2));
  }

  @Test
  public void testNotifyObserversAdd() {
    TerminalObserver observer = new TerminalObserver();
    testInstance.attach(observer);
    testInstance.addFlight(flight1);
    assertTrue(observer.getUpdateCalled());
  }

  @Test
  public void testNotifyObserversRemove() {
    TerminalObserver observer = new TerminalObserver();
    testInstance.addFlight(flight1);
    testInstance.attach(observer);
    testInstance.removeFlight(flight1);
    assertTrue(observer.getUpdateCalled());
  }

}
