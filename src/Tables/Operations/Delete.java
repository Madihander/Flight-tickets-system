package Tables.Operations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
    static Scanner scanner = new Scanner(System.in);
    public static ResultSet deleteById(Connection conn, String tableName) {
        ResultSet result = null;
        System.out.print("Enter Id:");
        int id = scanner.nextInt();

        Statement stmt;
        try {
            String query = String.format("DELETE FROM %s WHERE id = %s", tableName, id);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
