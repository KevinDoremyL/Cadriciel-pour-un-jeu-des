import java.util.LinkedList;
import java.util.List;

public class TerminalScreenTest {

  public TerminalScreenTest() {
    super();
  }

  private static final int FLIGHT_PARAM_COUNT = 6;

  private static void displayUsage() {
    System.out.println("Usage:");
    System.out.println("Number of arguments: 1 + " + FLIGHT_PARAM_COUNT + " * n (n >= 0)");
    System.out.println("0: screen name");
    System.out.println("1: company");
    System.out.println("2: flight number");
    System.out.println("3: destination");
    System.out.println("4: time");
    System.out.println("5: gate");
    System.out.println("6: status");
    System.out.println("etc.");
  }

  private static List<Flight> readFlights(String[] args) {
    if (args.length < 1 || (args.length - 1) % FLIGHT_PARAM_COUNT != 0) {
      displayUsage();
      throw new IllegalArgumentException("Invalid number of arguments: " + args.length);
    }

    List<Flight> flights = new LinkedList<Flight>();
    for (int i = 1; i < args.length; i += FLIGHT_PARAM_COUNT) {
      String company = args[i].replace('_', ' ');
      int flightNumber = Integer.parseInt(args[i + 1]);
      String destination = args[i + 2].replace('_', ' ');
      int departureTime = Integer.parseInt(args[i + 3]);
      String gate = args[i + 4];
      String status = args[i + 5].replace('_', ' ');
      flights.add(new Flight(company, flightNumber, destination, departureTime, gate, status));
    }

    return flights;
  }

  public static void main(String[] args) {

    List<Flight> flights = readFlights(args);
    String screenName = args[0].replace('_', ' ');

    Terminal subject = new Terminal("TERMINAL A");
    for (Flight flight : flights) {
      subject.addFlight(flight);
    }

    TerminalScreen observer = new TerminalScreen(subject, screenName);
    // subject.attach(observer);
    observer.update();
  }

}
