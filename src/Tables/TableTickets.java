package Tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TableTickets{
    Scanner scanner = new Scanner(System.in);
    /*
    public void insertIntoTable(Connection conn, Ticket ticket, int idCustomer) {
        String tableName = "tickets";
        int place = ticket.getPlace();
        int number = ticket.getNumber();
        int numberFlight = ticket.getNumberFlight();
        int price = ticket.getPrice();
        String timeCreated = ticket.getTimeCreated();
        Statement stmt;
        try {
            String query =
                    String.format("INSERT INTO %s(place,number,numberFlight,price,timeCreated)" +
                                    " VALUES ('%s','%s','%s','%s','%s');",
                            tableName, place, number, numberFlight, price, timeCreated);
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
                System.out.print(res.getString("place") + "| ");
                System.out.print(res.getString("number") + "| ");
                System.out.print(res.getString("numberFlight") + "| ");
                System.out.print(res.getString("price") + "| ");
                System.out.println(res.getString("timeCreated") + "| ");
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
                System.out.print(res.getString("place") + "| ");
                System.out.print(res.getString("number") + "| ");
                System.out.print(res.getString("numberFlight") + "| ");
                System.out.print(res.getString("price") + "| ");
                System.out.println(res.getString("timeCreated") + "| ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteById(Connection conn) {
        String tableName = "tickets";
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
