package Tables.Operations;

import CommonClasses.СommonClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Insert {
    static Scanner scanner = new Scanner(System.in);
    public static ResultSet InsertIntoCustomers(Connection conn, СommonClass customer) {
        ResultSet result;
        String tableName = "customers";

        String name = customer.printInfo().get(0);

        String email = customer.printInfo().get(1);

        String password = customer.printInfo().get(2);

        String phoneNumber = customer.printInfo().get(3);

        double balance = Double.parseDouble(customer.printInfo().get(4));

        double luggage = Double.parseDouble(customer.printInfo().get(5));
        Statement stmt;
        try {
            String query =
                    String.format("INSERT INTO %s(name,password,email,phonenumber,balance, luggage)" +
                                    " VALUES ('%s','%s','%s','%s','%s','%s');",
                            tableName, name, password, email, phoneNumber, balance,luggage);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

        try {
            String query = String.format("SELECT id FROM %s WHERE name = '%s' AND password = '%s' ",
                    tableName, name, password
            );
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

        return result;
    }
    public static ResultSet insertIntoFligths(Connection conn, СommonClass flight) {
        ResultSet result;
        String tableName = "flights";

        String departureDate = flight.printInfo().get(0);
        String departure = flight.printInfo().get(1);
        String arrival = flight.printInfo().get(2);
        String startTime = flight.printInfo().get(3);
        String endTime = flight.printInfo().get(4);
        int cost = Integer.parseInt(flight.printInfo().get(5));
        Statement stmt;
        try {
            String query =
                    String.format("INSERT INTO %s(departuredate,departure,arrival,startTime,endTime,cost)" +
                                    " VALUES ('%s','%s','%s','%s','%s','%s');",
                            tableName, departureDate, departure, arrival, startTime, endTime, cost);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        try {
            String query = String.format("SELECT id FROM %s WHERE departuredate = '%s' AND arrival = '%s' AND startTime = '%s' AND endTime = '%s' ",
                    tableName, departureDate, arrival, startTime, endTime
            );
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

        return result;
    }

}
