import java.sql.Connection;
import java.sql.ResultSet;

public class Admin extends Customer {
    TableAirport Airports = new TableAirport();
    TableFlights Flights = new TableFlights();

    TableCustomer Customers = new TableCustomer();
    TablePassengers Passengers = new TablePassengers();

    TableTickets Tickets = new TableTickets();

    public Admin(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    public void addNewCustomer(Customer customer, Connection conn) {
        Customers.insertIntoTable(conn, customer);
    }

    public void addNewAirport(Airport airport, Connection conn) {
        Airports.insertIntoTable(conn, airport);
    }

    public void addNewFlight(Flight flight, Connection conn, String location) {
        Flights.insertIntoTable(conn, flight, location);
    }

    public ResultSet findCustomer(String name, String password, Connection conn) {
        return Customers.findCustomer(conn, name, password);
    }

    public void readAirports(Connection conn) {
        Airports.readData(conn);
    }

    public void readFlight(Connection conn) {
        Flights.readData(conn);
    }
    public  void deleteAirport(Connection conn) {
        Airports.deleteById(conn);
    }
    public void deleteFlight(Connection conn) {
        Flights.deleteById(conn);
    }
}
