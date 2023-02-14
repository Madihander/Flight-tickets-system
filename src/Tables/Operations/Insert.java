package Tables.Operations;

import CommonClasses.Airport;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Insert {
    static Scanner scanner = new Scanner(System.in);

    public static String insertIntoAirports(Connection conn) {
        String result = null;
        String tableName = "airports";

        System.out.println("Enter title of Airport");
        String title = scanner.next();

        System.out.println("Enter location of Airport");
        String location = scanner.next();

        Statement stmt;
        try {
            String query =
                    String.format("INSERT INTO %s(title,location) VALUES ('%s','%s');", tableName, title, location);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            result = ("Row Inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public static String InsertIntoCustomers(Connection conn) {
        String result = null;
        String tableName = "customers";

        System.out.println("Enter name: ");
        String name = scanner.next();

        System.out.println("Enter password: ");
        String password = scanner.next();

        System.out.println("Enter email: ");
        String email = scanner.next();

        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.next();

        System.out.println("Enter balance: ");
        double balance = scanner.nextDouble();

        Statement stmt;
        try {
            String query =
                    String.format("INSERT INTO %s(name,password,email,phonenumber,balance)" +
                                    " VALUES ('%s','%s','%s','%s','%s');",
                            tableName, name, password, email, phoneNumber, balance);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            result = ("Row Inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public static String insertIntoPassengers(Connection conn) {
        String result = null;
        String tableName = "passengers";



        System.out.println("Enter title of Airport");
        String title = scanner.next();

        System.out.println("Enter location of Airport");
        String location = scanner.next();

        Statement stmt;
        try {
            String query =
                    String.format("INSERT INTO %s(title,location) VALUES ('%s','%s');", tableName, title, location);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            result = ("Row Inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
