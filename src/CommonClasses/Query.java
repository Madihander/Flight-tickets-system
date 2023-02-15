package CommonClasses;

import java.util.ArrayList;

public class Query implements СommonClass{
    String query;
    public Query(String str){
        query = str;
    }

    @Override
    public ArrayList<String> printInfo() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(query);
        return data;
    }
}
