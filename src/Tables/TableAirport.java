package Tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TableAirport{
    Scanner scanner = new Scanner(System.in);
    /*
    public void insertIntoTable(Connection conn, Airport airport) {
        String tableName = "airports";
        String title = airport.getTitle();
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

    @Override
    public void readData(Connection conn) {
        String tableName = "airports";
        Statement stmt;
        ResultSet res = null;

        try {
            String query = String.format("SELECT * FROM %s", tableName);
            stmt = conn.createStatement();
            res = stmt.executeQuery(query);
            while (res.next()) {
                System.out.print(res.getString("id") + " ");
                System.out.print(res.getString("title") + " ");
                System.out.println(res.getString("location") + " ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void searchById(Connection conn) {
        String tableName = "airports";
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
                System.out.print(res.getString("title") + "| ");
                System.out.println(res.getString("location") + "| ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteById(Connection conn) {
        String tableName = "airports";
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
