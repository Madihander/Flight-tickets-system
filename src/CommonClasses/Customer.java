package CommonClasses;

import java.util.ArrayList;

public class Customer implements СommonClass {
    private final String name;
    private int id;
    private String password;

    private final String email;
    private final String phoneNumber;

    private double balance;

    public Customer(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = generatePassword();
    }

    public void setId(int num) {
        this.id = num;
    }

    public int getId() {
        return this.id;
    }

    public void setBalance(double num) {
        this.balance = num;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public String generatePassword() {
        int length = 8;
        String set = "1234567890";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * set.length());
            password[i] = set.charAt(rand);
        }
        return new String(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public ArrayList<String> printInfo() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(this.name);
        data.add(this.email);
        data.add(this.password);
        data.add(this.phoneNumber);
        data.add(String.valueOf(this.balance));

        return data;

    }
}
