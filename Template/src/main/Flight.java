
import java.util.Objects;

public class Flight {

  private String company = "";
  private int flightNumber = 0;
  private String destination = "";
  private int departureTime = 0;
  private String gate = "";
  private String status = "";

  /**
   * Constant string for the ON TIME status
   */
  public static final String ONTIME = "ON TIME";

  /**
   * Constant string for the BOARDING status
   */

  public Flight(String company, int flightNumber, String destination, int departureTime, String gate, String status) {
    this.company = company;
    this.flightNumber = flightNumber;
    this.destination = destination;
    this.departureTime = departureTime;
    this.gate = gate;
    this.status = status;
  }

  public String getCompany() {
    return this.company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public int getFlightNumber() {
    return this.flightNumber;
  }

  public void setFlightNumber(int flightNumber) {
    this.flightNumber = flightNumber;
  }

  public String getDestination() {
    return this.destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public int getDepartureTime() {
    return this.departureTime;
  }

  public void setDepartureTime(int departureTime) {
    this.departureTime = departureTime;
  }

  public String getGate() {
    return this.gate;
  }

  public void setGate(String gateNumber) {
    this.gate = gateNumber;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Flight company(String company) {
    this.company = company;
    return this;
  }

  public Flight flightNumber(int flightNumber) {
    this.flightNumber = flightNumber;
    return this;
  }

  public Flight destination(String destination) {
    this.destination = destination;
    return this;
  }

  public Flight departureTime(int departureTime) {
    this.departureTime = departureTime;
    return this;
  }

  public Flight gate(String gate) {
    this.gate = gate;
    return this;
  }

  public Flight status(String status) {
    this.status = status;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Flight)) {
      return false;
    }
    Flight flight = (Flight) o;
    return Objects.equals(company, flight.company) && flightNumber == flight.flightNumber
        && Objects.equals(destination, flight.destination) && departureTime == flight.departureTime
        && Objects.equals(gate, flight.gate) && Objects.equals(status, flight.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(company, flightNumber, destination, departureTime, gate, status);
  }

  @Override
  public String toString() {
    return getCompany() + getFlightNumber() + " " + getDestination() + " " + getDepartureTime() + " " + getGate() + " "
        + getStatus();
  }

  public String getIDFight() {
    return getCompany() + getFlightNumber();
  }

  public static final String BOARDING = "BOARDING";
  /**
   * Constant string for the DELAYED status
   */
  public static final String DELAYED = "DELAYED";
  /**
   * Constant string for the CANCELLED status
   */
  public static final String CANCELLED = "CANCELLED";

}
