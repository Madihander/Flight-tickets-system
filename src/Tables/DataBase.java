package Tables;

import Tables.Operations.*;
import CommonClasses.СommonClass;

import java.sql.Connection;
import java.sql.ResultSet;

public class DataBase {
    public ResultSet insertIntoTable(Connection conn, СommonClass someClass, String tableName) {
        return chooseTable("insert", someClass, tableName, conn);
    }

    public ResultSet readData(Connection conn, СommonClass someClass, String tableName) {
        return chooseTable("read", someClass, tableName, conn);
    }

    public ResultSet findData(Connection conn, СommonClass someClass, String tableName) {

        return chooseTable("find", someClass, tableName, conn);
    }

    public ResultSet updateDate(Connection conn, СommonClass someClass, String tableName) {
        return chooseTable("update", someClass, tableName, conn);
    }

    public ResultSet deleteById(Connection conn, СommonClass someClass, String tableName) {
        return chooseTable("delete", someClass, tableName, conn);
    }

    private ResultSet chooseTable(String operation, СommonClass someClass, String tableName, Connection conn) {
        ResultSet result = null;
        switch (operation) {
            case "insert":
                switch (tableName) {
                    case "customers" -> result = Insert.InsertIntoCustomers(conn, someClass);
                    case "flights" -> result = Insert.insertIntoFligths(conn, someClass);
                }
                break;

            case "read":
                switch (tableName) {
                    case "customers", "flights" -> result = Read.readData(conn, tableName);
                }
                break;

            case "find":
                switch (tableName) {
                    case "customers", "flights" -> result = Find.findData(conn, someClass, tableName);
                }
                break;

            case "update":
                switch (tableName) {
                    case "customers", "flights" -> result = Update.updateById(conn, tableName);
                }
                break;

                case "delete":
                switch (tableName) {
                    case "customers", "flights" -> result = Delete.deleteById(conn, tableName);
                }
                break;
        }
        return result;
    }
}
