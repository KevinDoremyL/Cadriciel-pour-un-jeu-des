
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * This unit test class uses reflection to check for fields and methods.
 */
public class FlightTest {

  public FlightTest() {
    super();

  }

  // private static final float EPSILON = 1e-8f;

  private static Class<Flight> testClass;
  private static Constructor<Flight>[] testConstructors;
  private static Field[] testFields;
  private static Method[] testMethods;

  private static Flight testInstance;

  private static String company = "BA";
  private static int flightNumber = 714;
  private static String destination = "Sidney";
  private static int departureTime = 2155;
  private static String gate = "B-7";
  private static String status = Flight.ONTIME;

  private static Class<?>[] constExpectedParams = { String.class, int.class, String.class, int.class, String.class,
      String.class };

  /**
   * @return Empty String if no error
   */
  private static String checkConstructor() {
    String res = "";

    if (testConstructors.length != 1) {
      res = "Invalid number of constructors";
    } else if (testConstructors[0].getModifiers() != Modifier.PUBLIC) {
      res = "Wrong modifier";
    } else {
      final Class<?>[] constParams = testConstructors[0].getParameterTypes();
      if (constExpectedParams.length != constParams.length) {
        res = "Invalid number of parameters";
      } else {
        for (int i = 0; i < constParams.length; ++i) {
          if (!(constParams[i].equals(constExpectedParams[i]))) {
            res = "Invalid parameter type at position " + i;
            res += ": expected " + constExpectedParams[i] + " but found " + constParams[i];
            break;
          }
        }
      }
    }

    return res;
  }

  private static void assertConstructor() {
    final String res = checkConstructor();
    if (res != "") {
      fail(res);
    }
  }

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    testClass = Flight.class;
    testConstructors = (Constructor<Flight>[]) testClass.getDeclaredConstructors();
    testFields = testClass.getDeclaredFields();
    testMethods = testClass.getDeclaredMethods();

    assertConstructor();

    testInstance = (Flight) testConstructors[0].newInstance(company, flightNumber, destination, departureTime, gate,
        status);
  }

  private static Field getAccessibleField(final String fieldName) {
    Field field = null;

    for (final Field curField : testFields) {
      if (curField.getName().equals(fieldName)) {
        field = curField;
        field.setAccessible(true);
      }
    }

    return field;
  }

  private static Field assertField(final String fieldName, final Class<?> type, final int modifier) {
    boolean foundField = false;
    final Field resField = getAccessibleField(fieldName);
    if (resField != null) {
      // Test that it is the right type
      assertEquals(type, resField.getType());

      // Test that it is private
      assertEquals("Wrong modifier for field '" + fieldName + "'", modifier, resField.getModifiers());

      foundField = true;
    }

    // Test that we found it
    assertTrue("Field '" + fieldName + "' was not found", foundField);
    return resField;
  }

  private static void assertMethod(final String methodName, final Class<?> returnType, final int modifier,
      final int paramCount) {
    boolean foundMethod = false;
    for (final Method curMethod : testMethods) {
      // Check the signature
      if (curMethod.getName().equals(methodName) && curMethod.getParameterTypes().length == paramCount) {
        // Test that it is the right return type
        assertEquals(returnType, curMethod.getReturnType());

        // Test that it is public
        assertEquals("Wrong modifier for method '" + methodName + "'", modifier, curMethod.getModifiers());

        foundMethod = true;
        break;
      }
    }

    // Test that we found it
    assertTrue("Method '" + methodName + "' was not found", foundMethod);
  }

  private static void assertToString(final String company, final int flightNumber, final String destination,
      final int departureTime, final String gate, final String status, final String expected) {
    final Flight test = new Flight(company, flightNumber, destination, departureTime, gate, status);
    assertEquals(expected, test.toString());
  }

  @Test
  public void testConstructor1() throws IllegalAccessException {
    assertConstructor();

    // Check values
    assertEquals(company, getAccessibleField("company").get(testInstance));
    assertEquals(flightNumber, getAccessibleField("flightNumber").get(testInstance));
    assertEquals(destination, getAccessibleField("destination").get(testInstance));
    assertEquals(departureTime, getAccessibleField("departureTime").get(testInstance));
    assertEquals(gate, getAccessibleField("gate").get(testInstance));
    assertEquals(status, getAccessibleField("status").get(testInstance));
  }

  @Test
  public void testConstructor2() {
    final Flight testFlight = new Flight("AF", 873, "New-York", 0025, "C-2", Flight.DELAYED);

    // Check values
    assertEquals("AF", testFlight.getCompany());
    assertEquals(873, testFlight.getFlightNumber());
    assertEquals("New-York", testFlight.getDestination());
    assertEquals(0025, testFlight.getDepartureTime());
    assertEquals("C-2", testFlight.getGate());
    assertEquals(Flight.DELAYED, testFlight.getStatus());
  }

  @Test
  public void testCompany() throws IllegalAccessException {
    // Check that field exists
    final Field testField = assertField("company", String.class, Modifier.PRIVATE);
    final String previousValue = (String) testField.get(testInstance);

    // Check that getter exists
    assertMethod("getCompany", String.class, Modifier.PUBLIC, 0);

    // Change field value
    final String testValue = "EZY";
    testField.set(testInstance, testValue);

    // Test getter
    assertEquals(testValue, testInstance.getCompany());

    // Reset field value
    testField.set(testInstance, previousValue);
  }

  @Test
  public void testFlightNumber() throws IllegalAccessException {
    // Check that field exists
    final Field testField = assertField("flightNumber", int.class, Modifier.PRIVATE);
    final int previousValue = (int) testField.get(testInstance);

    // Check that getter exists
    assertMethod("getFlightNumber", int.class, Modifier.PUBLIC, 0);

    // Change field value
    final int testValue = 3210;
    testField.set(testInstance, testValue);

    // Test getter
    assertEquals(testValue, testInstance.getFlightNumber());

    // Reset field value
    testField.set(testInstance, previousValue);
  }

  @Test
  public void testDestination() throws IllegalAccessException {
    // Check that field exists
    final Field testField = assertField("destination", String.class, Modifier.PRIVATE);
    final String previousValue = (String) testField.get(testInstance);

    // Check that getter exists
    assertMethod("getDestination", String.class, Modifier.PUBLIC, 0);

    // Change field value
    final String testValue = "Casablanca";
    testField.set(testInstance, testValue);

    // Test getter
    assertEquals(testValue, testInstance.getDestination());

    // Reset field value
    testField.set(testInstance, previousValue);
  }

  @Test
  public void testDepartureTime() throws IllegalAccessException {
    // Check that field exists
    final Field testField = assertField("departureTime", int.class, Modifier.PRIVATE);
    final int previousValue = (int) testField.get(testInstance);

    // Check that getter exists
    assertMethod("getDepartureTime", int.class, Modifier.PUBLIC, 0);

    // Change field value
    final int testValue = 1630;
    testField.set(testInstance, testValue);

    // Test getter
    assertEquals(testValue, testInstance.getDepartureTime());

    // Reset field value
    testField.set(testInstance, previousValue);
  }

  @Test
  public void testGate() throws IllegalAccessException {
    // Check that field exists
    final Field testField = assertField("gate", String.class, Modifier.PRIVATE);
    final String previousValue = (String) testField.get(testInstance);

    // Check that getter exists
    assertMethod("getGate", String.class, Modifier.PUBLIC, 0);

    // Change field value
    final String testValue = "A-2";
    testField.set(testInstance, testValue);

    // Test getter
    assertEquals(testValue, testInstance.getGate());

    // Reset field value
    testField.set(testInstance, previousValue);
  }

  @Test
  public void testStatus() throws IllegalAccessException {
    // Check that field exists
    final Field testField = assertField("status", String.class, Modifier.PRIVATE);
    final String previousValue = (String) testField.get(testInstance);

    // Check that getter exists
    assertMethod("getStatus", String.class, Modifier.PUBLIC, 0);

    // Change field value
    final String testValue = Flight.BOARDING;
    testField.set(testInstance, testValue);

    // Test getter
    assertEquals(testValue, testInstance.getStatus());

    // Reset field value
    testField.set(testInstance, previousValue);
  }

  @Test
  public void testToString1() {
    assertToString(company, flightNumber, destination, departureTime, gate, status,
        company + flightNumber + " " + destination + " " + departureTime + " " + gate + " " + status);
  }

  @Test
  public void testToString2() {
    assertToString("AA", 877, "Tokyo", 1700, "C-1", Flight.CANCELLED, "AA877 Tokyo 1700 C-1 CANCELLED");
  }

}
