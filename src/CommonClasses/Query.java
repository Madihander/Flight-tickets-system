package CommonClasses;

import java.util.ArrayList;

public class Query implements СommonClass {
    String query;
    String var1;
    String var2;
    String var3;

    public Query(String str, String var1, String var2, String var3) {
        this.query = str;
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
    }

    @Override
    public ArrayList<String> printInfo() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(query);
        data.add(var1);
        data.add(var2);
        data.add(var3);
        return data;
    }
}
