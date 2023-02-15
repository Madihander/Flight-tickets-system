import CommonClasses.СommonClass;

import java.sql.ResultSet;

public interface Command {
    public ResultSet execute(СommonClass someClass, String tableName);
}
