import Tables.DataBase;
import CommonClasses.dbConnection;
import Tables.Operations.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertCommand implements Command{
    DataBase dataBase;
    Connection conn;
    public InsertCommand(DataBase dataBase) throws SQLException{
        this.dataBase = dataBase;
        conn = dbConnection.getInstance().getConnection();
    }
    @Override
    public void execute(String tableName) {
        dataBase.insertIntoTable(conn,tableName);
    }
}
