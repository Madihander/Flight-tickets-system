package Tables.Operations;
import CommonClasses.СommonClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Find {
    public static ResultSet findData(Connection conn, СommonClass someQuery, String tableName) {
        ResultSet result = null;
        String var = someQuery.printInfo().get(0);
        String var1 = someQuery.printInfo().get(1);
        String var2 = someQuery.printInfo().get(2);
        String var3 = someQuery.printInfo().get(3);
        Statement stmt;
        try {
            String query = String.format(var, tableName,var1,var2,var3);
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return result;
    }
}
