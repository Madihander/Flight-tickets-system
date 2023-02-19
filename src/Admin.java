import CommonClasses.СommonClass;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Admin implements СommonClass {
    private final String name;
    private final String password;
    Command insert;
    Command read;
    Command find;
    Command update;
    Command delete;

    public Admin(String name, Command insert, Command read, Command find,Command update, Command delete) {
        this.name = name;
        this.password = "12345";
        this.insert = insert;
        this.read = read;
        this.find = find;
        this.update = update;
        this.delete = delete;
    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public ArrayList<String> printInfo() {
        return null;
    }

}
