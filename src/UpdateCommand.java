import CommonClasses.dbConnection;
import CommonClasses.СommonClass;
import Tables.DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateCommand implements Command {
    DataBase dataBase;
    Connection conn;

    public UpdateCommand(DataBase dataBase) throws SQLException {
        this.dataBase= dataBase;
        conn = dbConnection.getInstance().getConnection();
    }

    @Override
    public ResultSet execute(СommonClass someClass, String tableName) {
        return dataBase.updateDate(conn,someClass,tableName);
    }
}
