import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TableCustomer  {
    Scanner scanner = new Scanner(System.in);

    public void insertIntoTable(Connection conn, Customer customer) {
        String tableName = "customers";
        String name = customer.getName();
        String password = customer.getPassword();
        String email = customer.getEmail();
        String phoneNumber = customer.getPhoneNumber();
        double balance = customer.getBalance();
        Statement stmt;
        try {
            String query =
                    String.format("INSERT INTO %s(name,password,email,phonenumber,balance)" +
                                    " VALUES ('%s','%s','%s','%s','%s');",
                            tableName, name, password, email, phoneNumber, balance);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Row Inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readData(Connection conn) {
        String tableName = "customers";
        Statement stmt;
        ResultSet res = null;

        try {
            String query = String.format("SELECT * FROM %s", tableName);
            stmt = conn.createStatement();
            res = stmt.executeQuery(query);
            while (res.next()) {
                System.out.print(res.getString("id") + "| ");
                System.out.print(res.getString("name") + "| ");
                System.out.print(res.getString("password") + "| ");
                System.out.print(res.getString("email") + "| ");
                System.out.print(res.getString("Phone number") + "| ");
                System.out.println(res.getString("balance") + "| ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet findCustomer(Connection conn, String name, String password) {
        String tableName = "customers";

        Statement stmt;
        ResultSet res = null;
        try {
            String query = String.format
                    ("SELECT * FROM %s WHERE name = '%s' AND password = '%s' ",
                            tableName, name, password
                    );
            stmt = conn.createStatement();
            res = stmt.executeQuery(query);
            /*while (res.next()) {
                System.out.print(res.getString("id") + "| ");
                System.out.print(res.getString("name")+ "| ");
                System.out.print(res.getString("password")+ "| ");
                System.out.print(res.getString("email")+ "| ");
                System.out.print(res.getString("Phone number")+ "| ");
                System.out.println(res.getString("balance")+ "| ");
            }*/
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    public void deleteById(Connection conn) {
        String tableName = "customers";
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
