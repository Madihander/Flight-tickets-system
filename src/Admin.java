import CommonClasses.Customer;
import CommonClasses.Flight;
//
import CommonClasses.Airport;

import java.sql.Connection;
import java.sql.ResultSet;

public class Admin extends Customer {
    /*TableAirport Airports = new TableAirport();
    TableFlights Flights = new TableFlights();

    TableCustomer Customers = new TableCustomer();
    TablePassengers Passengers = new TablePassengers();

    TableTickets Tickets = new TableTickets();*/
    Command insert;
    Command read;
    Command find;
    Command delete;

    public Admin(String name, String email, String phoneNumber,
                 Command insert, Command read, Command find, Command delete) {
        super(name, email, phoneNumber);
        this.insert = insert;
        this.read = read;
        this.find = find;
        this.delete = delete;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    public void insertRecord(String tableName) {
        insert.execute(tableName);
    }
    public void readData(String tableName) {
        read.execute(tableName);
    }
    public void findRecord(String tableName) {
        find.execute(tableName);
    }
    public void deleteRecord(String tableName) {
        delete.execute(tableName);
    }

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
