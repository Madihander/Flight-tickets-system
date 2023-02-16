import CommonClasses.Customer;
import CommonClasses.СommonClass;
import org.checkerframework.checker.units.qual.C;
//

import java.sql.ResultSet;
import java.util.ArrayList;

public class Admin implements СommonClass {
    /*TableAirport Airports = new TableAirport();
    TableFlights Flights = new TableFlights();

    TableCustomer Customers = new TableCustomer();
    TablePassengers Passengers = new TablePassengers();

    TableTickets Tickets = new TableTickets();*/

    private final String name;
    private final String password;
    Command insert;
    Command read;
    Command find;
    Command delete;

    public Admin(String name, Command insert, Command read, Command find, Command delete) {
        this.name = name;
        this.password = "12345";
        this.insert = insert;
        this.read = read;
        this.find = find;
        this.delete = delete;
    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public ArrayList<String> printInfo() {
        return null;
    }

    /*
    public void readData(String tableName) {
        read.execute(tableName);
    }
    public void findRecord(String tableName) {
        find.execute(tableName);
    }
    public void deleteRecord(String tableName) {
        delete.execute(tableName);
    }*/

    /*
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
     */
}
