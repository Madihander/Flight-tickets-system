package Tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class TableFlights {
    Scanner scanner = new Scanner(System.in);
    /*
    public void insertIntoTable(Connection conn, Flight flight, String locationAirport) {
        String tableName = "flights";

        int number = flight.getNumber();
        String departureDate = flight.getDepartureDate();
        String departure = flight.getDeparture();
        String arrival = flight.getArrival();
        String startTime = flight.getStartTime();
        String endTime = flight.getEndTime();
        int cost = flight.getCost();
        int[] places = flight.getPlaces();

        Statement stmt;
        try {
            String query =
                    String.format("INSERT INTO %s(number,locationAirport,departureDate,departure,arrival,startTime,endTime,cost,places)" +
                                    " VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s');",
                            number, locationAirport, departureDate, departure, arrival, startTime, endTime, cost, Arrays.toString(places));
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Row Inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void readData(Connection conn) {
        String tableName = "tickets";
        Statement stmt;
        ResultSet res = null;

        try {
            String query = String.format("SELECT * FROM %s", tableName);
            stmt = conn.createStatement();
            res = stmt.executeQuery(query);
            while (res.next()) {
                System.out.print(res.getString("id") + "| ");
                System.out.print(res.getString("number") + "| ");
                System.out.print(res.getString("locationAirport") + "| ");
                System.out.print(res.getString("departureDate") + "| ");
                System.out.print(res.getString("departure") + "| ");
                System.out.print(res.getString("arrival") + "| ");
                System.out.print(res.getString("startTime") + "| ");
                System.out.print(res.getString("endTime") + "| ");
                System.out.print(res.getString("cost") + "| ");
                System.out.println(res.getString("places") + "| ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void searchById(Connection conn) {
        String tableName = "tickets";
        System.out.print("Enter Id:");
        int id = scanner.nextInt();
        Statement stmt;
        ResultSet res = null;
        try {
            String query = String.format("SELECT * FROM %s WHERE id = '%s'", tableName, id);
            stmt = conn.createStatement();
            res = stmt.executeQuery(query);
            while (res.next()) {
                System.out.print(res.getString("id") + "| ");
                System.out.print(res.getString("number") + "| ");
                System.out.print(res.getString("locationAirport") + "| ");
                System.out.print(res.getString("departureDate") + "| ");
                System.out.print(res.getString("departure") + "| ");
                System.out.print(res.getString("arrival") + "| ");
                System.out.print(res.getString("startTime") + "| ");
                System.out.print(res.getString("endTime") + "| ");
                System.out.print(res.getString("cost") + "| ");
                System.out.println(res.getString("places") + "| ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteById(Connection conn) {
        String tableName = "Flights";
        System.out.print("Enter Id:");
        int id = scanner.nextInt();
        Statement stmt;
        try {
            String query = String.format("DELETE FROM %s WHERE id = %s", tableName, id);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Row deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

     */
}
