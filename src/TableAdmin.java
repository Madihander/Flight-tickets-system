import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TableAdmin {
    Scanner scanner = new Scanner(System.in);
    public void insertIntoTable(Connection conn, Admin admin) {
        String tableName = "admins";
        String name = admin.getName();
        String pass = admin.getPassword();
        String email = admin.getEmail();
        String phoneNumber = admin.getPhoneNumber();

        Statement stmt;
        try {
            String query =
                    String.format("INSERT INTO %s(name,pass,email,phoneNumber)" +
                                    " VALUES ('%s','%s','%s','%s');",
                            name,pass,email,phoneNumber);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Row Inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void readData(Connection conn) {
        String tableName = "admins";
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
                System.out.println(res.getString("Phone number") + "| ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
