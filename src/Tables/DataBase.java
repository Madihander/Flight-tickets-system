package Tables;

import Tables.Operations.Delete;
import Tables.Operations.Insert;
import CommonClasses.СommonClass;
import Tables.Operations.Read;

import java.sql.Connection;
import java.sql.ResultSet;

public class DataBase {
    public ResultSet insertIntoTable(Connection conn, СommonClass someClass, String tableName) {
        return chooseTable("insert", someClass, tableName, conn);
    }

    public ResultSet readData(Connection conn, СommonClass someClass, String tableName) {
        return chooseTable("read", someClass, tableName, conn);
    }

    public void searchById(Connection conn, String tableName) {

    }

    public ResultSet deleteById(Connection conn, СommonClass someClass, String tableName) {
        return null;
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

            case "read":
                switch (tableName) {
                    case "airports", "customers", "tickets", "passengers", "flights" ->
                            result = Read.readData(conn, tableName);
                }
                break;
            case "delete":
                switch (tableName){
                    case "airports", "customers", "tickets", "passengers", "flights" ->
                            result = Delete.deleteById(conn, tableName);
                }
        }
        return result;
    }
}
