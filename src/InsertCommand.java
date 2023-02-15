import Tables.DataBase;
import CommonClasses.dbConnection;
import CommonClasses.СommonClass;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertCommand implements Command {
    DataBase dataBase;
    Connection conn;

    public InsertCommand(DataBase dataBase) throws SQLException {
        this.dataBase = dataBase;
        conn = dbConnection.getInstance().getConnection();
    }

    @Override
    public String execute(СommonClass someClass, String tableName) {
        return dataBase.insertIntoTable(conn, someClass, tableName);
    }
}
