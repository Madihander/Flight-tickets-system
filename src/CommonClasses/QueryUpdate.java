package CommonClasses;

import java.util.ArrayList;

public class QueryUpdate implements СommonClass {
    private final int id;
    private final String query;
    private final String column;
    private final int updateData;

    public QueryUpdate(int id, String query,String column, int updateData) {
        this.id = id;
        this.query = query;
        this.column = column;
        this.updateData = updateData;
    }

    @Override
    public ArrayList<String> printInfo() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(String.valueOf(id));
        data.add(query);
        data.add(column);
        data.add(String.valueOf(updateData));
        return data;
    }
}
