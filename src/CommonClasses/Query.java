package CommonClasses;

import java.util.ArrayList;

public class Query implements СommonClass{
    String query;
    ArrayList<String> queryData = new ArrayList<String>();
    public Query(String str,ArrayList<String> queryData){
        this.query = str;
        this.queryData = queryData;
    }

    @Override
    public ArrayList<String> printInfo() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(query);
        data.add(queryData.get(0));
        data.add(queryData.get(1));
        data.add(queryData.get(2));
        return data;
    }
}
