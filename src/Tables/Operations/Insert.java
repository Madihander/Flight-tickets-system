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
}
