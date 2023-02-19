package CommonClasses;

public class QueryUpdate {
    private final String query;
    private final String column;
    private final String updateData;

    public QueryUpdate(String query,String column, String updateData) {
        this.query = query;
        this.column = column;
        this.updateData = updateData;
    }

    public String getQuery() {
        return query;
    }

    public String getColumn() {
        return column;
    }
    public String getUpdateData() {
        return updateData;
    }
}
