import CommonClasses.dbConnection;
import CommonClasses.СommonClass;
import Tables.DataBase;
import Tables.Operations.Read;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadCommand implements Command {
    DataBase dataBase;
    Connection conn;

    public ReadCommand(DataBase dataBase) throws SQLException {
        this.dataBase= dataBase;
        conn = dbConnection.getInstance().getConnection();
    }

    @Override
    public ResultSet execute(СommonClass someClass, String tableName) {
        return dataBase.readData(conn,someClass,tableName);
    }
}
