import java.sql.Connection;

public abstract class Table {

    public abstract void readData(Connection conn);
    public abstract void searchById(Connection conn);
    public abstract void deleteById(Connection conn);
}
