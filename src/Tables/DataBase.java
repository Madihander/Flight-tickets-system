package Tables;
import Tables.Operations.Insert;

import java.sql.Connection;
import java.sql.Statement;
public class DataBase {
    public String insertIntoTable(Connection conn, String tableName) {
        return chooseTable("insert",tableName,conn);
    }

    public void readData(Connection conn, String tableName) {

    }

    public void searchById(Connection conn, String tableName) {

    }

    public void deleteById(Connection conn, String tableName) {
    }

    private String chooseTable(String operation, String tableName, Connection conn) {
        String result = null;
        switch (operation) {
            case "insert":
                switch (tableName) {
                    case "airports":
                        result = Insert.insertIntoAirports(conn);
                        break;
                    case "customers":
                        break;
                    case "passengers":
                        break;
                    case "flights":
                        break;
                    case "tickets":
                        break;

                }
                break;
        }
        return result;
    }
}
