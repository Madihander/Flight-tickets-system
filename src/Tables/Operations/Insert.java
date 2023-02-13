package Tables.Operations;
import CommonClasses.Airport;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Insert {
    static Scanner scanner = new Scanner(System.in);
    public static void insertIntoAirports(Connection conn) {
        String tableName = "airports";
        System.out.println("Enter title of Airport");
        String title = scanner.next();
        String location = airport.getLocation();
        Statement stmt;
        try {
            String query =
                    String.format("INSERT INTO %s(title,location) VALUES ('%s','%s');", tableName, title, location);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Row Inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
