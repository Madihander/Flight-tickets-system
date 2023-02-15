package Tables.Operations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Read {
    static Scanner scanner = new Scanner(System.in);
    public static ResultSet readData(Connection conn,String tableName) {
        ResultSet result = null;

        Statement stmt;
        try {
            String query = String.format("SELECT * FROM %s", tableName);
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        } catch (Exception e) {
            return (ResultSet) e;
        }
        return result;
    }
}
