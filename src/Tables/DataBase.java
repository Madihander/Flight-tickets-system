package Tables;
import Tables.Operations.Insert;
import CommonClasses.СommonClass;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class DataBase {
    public ResultSet insertIntoTable(Connection conn, СommonClass someClass, String tableName) {
        return chooseTable("insert",someClass,tableName,conn);
    }

    public void readData(Connection conn, String tableName) {

    }

    public void searchById(Connection conn, String tableName) {

    }

    public void deleteById(Connection conn, String tableName) {
    }

    private ResultSet chooseTable(String operation, СommonClass someClass, String tableName, Connection conn) {
        ResultSet result = null;
        switch (operation) {
            case "insert":
                switch (tableName) {
                    case "airports" -> result = Insert.insertIntoAirports(conn, someClass);
                    case "customers" -> result = Insert.InsertIntoCustomers(conn, someClass);
                    case "tickets" -> result = Insert.InsertIntoTickets(conn, someClass);
                    case "passengers" -> result = Insert.insertIntoPassengers(conn, someClass);
                    case "flights" -> result = Insert.insertIntoFligths(conn, someClass);
                }
                break;
        }
        return result;
    }
}
