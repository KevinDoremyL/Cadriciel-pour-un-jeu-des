
public class TerminalScreen extends Observer {

    private Terminal terminal;
    private String nomEcran;

    public TerminalScreen(Terminal terminal, String nomEcran) {
        this.terminal = terminal;
        this.nomEcran = nomEcran;
    }

    @Override
    public void update() {
        System.out.println(nomEcran);

        for (Flight f : terminal.getFlights()) {
            System.out.println(f.toString());
        }

    }

}