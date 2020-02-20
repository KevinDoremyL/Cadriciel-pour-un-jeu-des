package com.idk;

import java.util.LinkedList;
import java.util.List;

public class Airport extends Subject {
    List<Flight> listFlight = new LinkedList<Flight>();

    @Override
    public void addFlight(Flight flight) {
        listFlight.add(flight);
        notifyObservers();
    }

    @Override
    public void removeFlight(Flight flight) {
        listFlight.remove(flight);
        notifyObservers();

    }

    @Override
    public List<Flight> getFlights() {

        return listFlight;
    }

}