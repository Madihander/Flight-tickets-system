package CommonClasses;

import java.util.ArrayList;

public class ScheduledFlight {
    private ArrayList<Flight> flights = new ArrayList<Flight>();

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Flight flight) {
        flights.add(flight);
    }

    public void removeFlights(Flight flight) {
        flights.remove(flight);
    }
}
