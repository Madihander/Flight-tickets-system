package Tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TablePassengers extends Table {
    Scanner scanner = new Scanner(System.in);

    public void insertIntoTable(Connection conn, Passenger passenger, int numberTicket) {

        String tableName = "passengers";
        double luggage = passenger.getLuggage();
        double extraLuggage = passenger.getExtraLuggage();
        Statement stmt;
        try {
            String query =
                    String.format("INSERT INTO %s(numberTicket,luggage,extraLuggage)" +
                                    " VALUES ('%s','%s','%s');",
                            tableName, numberTicket, luggage, extraLuggage);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Row Inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void readData(Connection conn) {
        String tableName = "passengers";
        Statement stmt;
        ResultSet res = null;

        try {
            String query = String.format("SELECT * FROM %s", tableName);
            stmt = conn.createStatement();
            res = stmt.executeQuery(query);
            while (res.next()) {
                System.out.print(res.getString("id") + "| ");
                System.out.print(res.getString("number Ticket") + "| ");
                System.out.print(res.getString("luggage") + "| ");
                System.out.println(res.getString("extraLuggage") + "| ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void searchById(Connection conn) {
        String tableName = "passengers";
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
                System.out.print(res.getString("number Ticket") + "| ");
                System.out.print(res.getString("luggage") + "| ");
                System.out.println(res.getString("extraLuggage") + "| ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteById(Connection conn) {
        String tableName = "passengers";
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
}
