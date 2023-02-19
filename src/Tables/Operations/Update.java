package Tables.Operations;
import CommonClasses.СommonClass;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Update {
    static Scanner scanner = new Scanner(System.in);
    public static ResultSet updateById(Connection conn,СommonClass queryClass, String tableName) {
        ResultSet result = null;
        int id = Integer.parseInt(queryClass.printInfo().get(0));
        String queryString = queryClass.printInfo().get(1);
        String column = queryClass.printInfo().get(2);
        int updateData = Integer.parseInt(queryClass.printInfo().get(3));

        Statement stmt;
        try {
            String query = String.format(queryString, tableName, column,updateData,id);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
