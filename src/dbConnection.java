import java.sql.*;

public class dbConnection {
    TableAdmin tableAdmin = new TableAdmin();
    TableAirport tableAirport = new TableAirport();
    TableCustomer tableCustomer = new TableCustomer();
    TablePassengers tablePassengers = new TablePassengers();
    TableTickets tableTickets = new TableTickets();
    TableFlights tableFlights = new TableFlights();

    public Connection connect_to_db(String DB_URL, String DB_USERNAME, String DB_PASSWORD) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Drivers is not found");
            e.printStackTrace();
        }
        System.out.println("PostgreSQL JDBC Drivers successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
        return connection;
    }

    public TableAdmin getTableAdmin() {
        return tableAdmin;
    }

    public TableAirport getTableAirport() {
        return tableAirport;
    }

    public TableCustomer getCustomer() {
        return tableCustomer;
    }

    public TablePassengers getTablePassengers() {
        return tablePassengers;
    }

    public TableTickets getTableTickets() {
        return tableTickets;
    }

    public TableFlights getTableFlights() {
        return tableFlights;
    }
/*
    public void insertIntoAirport(Connection conn, String title, String location) {
        String tableName = "airports";
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

    public void read_data(Connection conn, String table_name) {
        Statement stmt;
        ResultSet res = null;
        try {
            String query = String.format("SELECT * FROM %s", table_name);
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

    public void update_name(Connection conn, String table_name, String old_title, String new_title) {
        Statement stmt;
        try {
            String query = String.format("UPDATE %s SET title = '%s' WHERE title = '%s'", table_name, new_title, old_title);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Data update");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void search_by_name(Connection conn, String table_name, String name) {
        Statement stmt;
        ResultSet res = null;
        try {
            String query = String.format("SELECT * FROM %s WHERE title = '%s'", table_name, name);
            stmt = conn.createStatement();
            res = stmt.executeQuery(query);
            while (res.next()) {
                System.out.print(res.getString("id"));
                System.out.print(res.getString("title"));
                System.out.println(res.getString("location"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void search_by_id(Connection conn, String table_name, int id) {
        Statement stmt;
        ResultSet res = null;
        try {
            String query = String.format("SELECT * FROM %s WHERE id = '%s'", table_name, id);
            stmt = conn.createStatement();
            res = stmt.executeQuery(query);
            while (res.next()) {
                System.out.print(res.getString("id") + " ");
                System.out.print(res.getString("title")+ " ");
                System.out.println(res.getString("location")+ " ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete_by_name(Connection conn, String table_name, String title) {
        Statement stmt;
        try {
            String query = String.format("DELETE FROM %s WHERE title = '%s'",table_name,title);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Row deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void delete_by_id(Connection conn, String table_name, int id) {
        Statement stmt;
        try {
            String query = String.format("DELETE FROM %s WHERE id = %s",table_name,id);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Row deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
*/


}
