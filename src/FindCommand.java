import CommonClasses.dbConnection;
import CommonClasses.СommonClass;
import Tables.DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindCommand implements Command {
    DataBase dataBase;
    Connection conn;

    public FindCommand(DataBase dataBase) throws SQLException {
        this.dataBase = dataBase;
        conn = dbConnection.getInstance().getConnection();
    }

    @Override
    public ResultSet execute(СommonClass someClass, String tableName) {
        return dataBase.findData(conn, someClass, tableName);
    }
}
