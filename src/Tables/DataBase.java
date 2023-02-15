package Tables;
import Tables.Operations.Insert;
import CommonClasses.СommonClass;
import java.sql.Connection;
import java.sql.Statement;
public class DataBase {
    public String insertIntoTable(Connection conn, СommonClass someClass, String tableName) {
        return chooseTable("insert",someClass,tableName,conn);
    }

    public void readData(Connection conn, String tableName) {

    }

    public void searchById(Connection conn, String tableName) {

    }

    public void deleteById(Connection conn, String tableName) {
    }

    private String chooseTable(String operation, СommonClass someClass, String tableName, Connection conn) {
        String result = null;
        switch (operation) {
            case "insert":
                switch (tableName) {
                    case "airports":
                        result = Insert.insertIntoAirports(conn,someClass);
                        break;
                    case "customers":
                        result = Insert.InsertIntoCustomers(conn,someClass);
                        break;
                    case "tickets":
                        result = Insert.InsertIntoTickets(conn,someClass);
                        break;
                    case "passengers":
                        result = Insert.insertIntoPassengers(conn,someClass);
                        break;
                    case "flights":
                        result = Insert.insertIntoFligths(conn,someClass);
                        break;


                }
                break;
        }
        return result;
    }
}
