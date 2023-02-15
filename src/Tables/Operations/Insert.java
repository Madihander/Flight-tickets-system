package Tables.Operations;

import CommonClasses.СommonClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Insert {
    static Scanner scanner = new Scanner(System.in);

    public static ResultSet insertIntoAirports(Connection conn, СommonClass airport) {
        ResultSet result;
        int id = 0;
        String tableName = "airports";

        String title = airport.printInfo().get(0);

        String location = airport.printInfo().get(1);

        Statement stmt;
        try {
            String query =
                    String.format("INSERT INTO %s(title,location) VALUES ('%s','%s');", tableName, title, location);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            return (ResultSet) e;
        }

        try {
            String query = String.format("SELECT id FROM %s WHERE title = '%s' AND location = '%s' ",
                    tableName, title, location
            );
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        } catch (Exception e) {
            return (ResultSet) e;
        }
        return result;
    }

    public static String InsertIntoCustomers(Connection conn, СommonClass customer) {
        ResultSet result;
        int id = 0;
        String tableName = "customers";

        String name = customer.printInfo().get(0);

        String email = customer.printInfo().get(1);

        String password = customer.printInfo().get(2);

        String phoneNumber = customer.printInfo().get(3);

        double balance = Double.parseDouble(customer.printInfo().get(4));

        Statement stmt;
        try {
            String query =
                    String.format("INSERT INTO %s(name,password,email,phonenumber,balance)" +
                                    " VALUES ('%s','%s','%s','%s','%s');",
                            tableName, name, password, email, phoneNumber, balance);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            return String.valueOf(e);
        }

        try {
            String query = String.format("SELECT id FROM %s WHERE name = '%s' AND password = '%s' ",
                    tableName, name, password
            );
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
            while (result.next()) {
                id = result.getInt("id");
            }
        } catch (Exception e) {
            return String.valueOf(e);
        }

        return String.valueOf(id);
    }

    public static String InsertIntoTickets(Connection conn, СommonClass ticket) {
        ResultSet result;
        int id = 0;
        String tableName = "tickets";

        String owner = ticket.printInfo().get(0);

        int place = Integer.parseInt(ticket.printInfo().get(1));

        int numberFlight = Integer.parseInt(ticket.printInfo().get(2));

        int price = Integer.parseInt(ticket.printInfo().get(3));


        Statement stmt;
        try {
            String query =
                    String.format("INSERT INTO %s(owner,place,numberflight,price)" +
                                    " VALUES ('%s','%s','%s','%s');",
                            tableName, owner, place, numberFlight, price);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            return String.valueOf(e);
        }

        try {
            String query = String.format("SELECT id FROM %s WHERE owner = '%s' AND numberflight = '%s' ",
                    tableName, owner, numberFlight
            );
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
            while (result.next()) {
                id = result.getInt("id");
            }
        } catch (Exception e) {
            return String.valueOf(e);
        }

        return String.valueOf(id);
    }

    public static String insertIntoPassengers(Connection conn, СommonClass passenger) {
        ResultSet result;
        int id = 0;
        String tableName = "passengers";

        int numberTicket = Integer.parseInt(passenger.printInfo().get(0));

        double luggage = Double.parseDouble(passenger.printInfo().get(1));

        double extraLuggage = Double.parseDouble(passenger.printInfo().get(2));

        Statement stmt;
        try {
            String query =
                    String.format("INSERT INTO %s(numberticket,luggage,extraLuggage) VALUES ('%s','%s','%s');", tableName, numberTicket, luggage, extraLuggage);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            return String.valueOf(e);
        }
        try {
            String query = String.format("SELECT id FROM %s WHERE numberticket = '%s' AND luggage = '%s' ",
                    tableName, numberTicket, luggage
            );
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
            while (result.next()) {
                id = result.getInt("id");
            }
        } catch (Exception e) {
            return String.valueOf(e);
        }

        return String.valueOf(id);
    }

    public static String insertIntoFligths(Connection conn, СommonClass flight) {
        ResultSet result;
        int id = 0;
        String tableName = "flights";

        String locationAirport = flight.printInfo().get(0);
        String departureDate = flight.printInfo().get(1);
        String arrival = flight.printInfo().get(2);
        String startTime = flight.printInfo().get(3);
        String endTime = flight.printInfo().get(4);
        int cost = Integer.parseInt(flight.printInfo().get(5));
        int places = Integer.parseInt(flight.printInfo().get(6));

        Statement stmt;
        try {
            String query =
                    String.format("INSERT INTO %s(locationAirport,departureDate,arrival,startTime,endTime,cost,places)" +
                                    " VALUES ('%s','%s','%s','%s','%s','%s','%s');",
                            tableName,locationAirport, departureDate, arrival, startTime, endTime, cost,places);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            return String.valueOf(e);
        }
        try {
            String query = String.format("SELECT id FROM %s WHERE locationAirport = '%s' AND arrival = '%s' AND startTime = '%s' AND endTime = '%s' ",
                    tableName, locationAirport, arrival,startTime,endTime
            );
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
            while (result.next()) {
                id = result.getInt("id");
            }
        } catch (Exception e) {
            return String.valueOf(e);
        }

        return String.valueOf(id);
    }

}
