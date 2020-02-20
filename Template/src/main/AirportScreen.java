
public class AirportScreen extends Observer {

    Airport airport;
    String nomEcran;

    public AirportScreen(Airport airport, String nomEcran) {
        this.airport = airport;
        this.nomEcran = nomEcran;
    }

    @Override
    public void update() {

        System.out.println(this.nomEcran);
        for (Flight f : airport.getFlights()) {
            System.out.println(f.toString());
        }

    }

}