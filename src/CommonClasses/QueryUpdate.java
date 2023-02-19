package CommonClasses;

import java.util.ArrayList;

public class QueryUpdate implements СommonClass {
    private final String query;
    private final String column;
    private final String updateData;

    public QueryUpdate(String query,String column, String updateData) {
        this.query = query;
        this.column = column;
        this.updateData = updateData;
    }

    @Override
    public ArrayList<String> printInfo() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(query);
        data.add(column);
        data.add(updateData);
        return data;
    }
}
