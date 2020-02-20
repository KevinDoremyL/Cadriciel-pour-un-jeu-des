package com.idk;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Modifier;

public class AirportTest {

  static class AirportObserver extends Observer {
    private boolean updateCalled = false;

    public boolean getUpdateCalled() {
      return updateCalled;
    }

    public void update() {
      updateCalled = true;
    }
  }

  private static Class<Airport> testClass;
  private Airport testInstance;

  private static Flight flight1;
  private static Flight flight2;
  private static Flight flight3;

  @Before
  public void setUpBefore() {
    testClass = Airport.class;
    testInstance = new Airport();

    flight1 = new Flight("BC", 135, "Vancouver", 1710, "C-2", Flight.ONTIME);
    flight2 = new Flight("AM", 560, "Buenos Aires", 1450, "B-5", Flight.ONTIME);
    flight3 = new Flight("UA", 441, "Los Angeles", 1830, "A-2", Flight.ONTIME);
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
    AirportObserver observer = new AirportObserver();
    testInstance.attach(observer);
    testInstance.addFlight(flight1);
    assertTrue(observer.getUpdateCalled());
  }

  @Test
  public void testNotifyObserversRemove() {
    AirportObserver observer = new AirportObserver();
    testInstance.addFlight(flight1);
    testInstance.attach(observer);
    testInstance.removeFlight(flight1);
    assertTrue(observer.getUpdateCalled());
  }

}
