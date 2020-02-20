
public class GateScreen extends Observer {

    private Gate gate;

    public GateScreen(Gate gate) {
        this.gate = gate;
    }

    @Override
    public void update() {

        System.out.println("GATE" + " " + gate.nomEcran);

        for (Flight f : gate.getFlights()) {
            System.out.println(f.toString());
        }

    }

}