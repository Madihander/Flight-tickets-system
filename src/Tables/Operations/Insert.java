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

    public static String InsertIntoCustomers(Connection conn,СommonClass customer) {
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
            System.out.println(e);
        }

        try {
            String query = String.format("SELECT id FROM %s WHERE name = '%s' AND password = '%s' ",
                    tableName, name, password
            );
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
            while (result.next()){
                id = result.getInt("id");
            }
        }catch (Exception e) {
            System.out.println(e);
        }

        return String.valueOf(id);
    }

    public static String insertIntoPassengers(Connection conn, СommonClass someClass) {
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
