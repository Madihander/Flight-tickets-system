package CommonClasses;

import java.util.ArrayList;

public class Customer implements СommonClass {
    private int id;
    private final String name;
    private String password;

    private final String email;
    private final String phoneNumber;
    private double balance;

    private final double luggage;

    private int ticket;

    public Customer(String name, String email, String phoneNumber, double balance, double luggage) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = generatePassword();
        this.balance = balance;
        this.luggage = luggage;
    }

    public int getId() {
        return this.id;
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

    public double getLuggage() {
        return luggage;
    }

    public int getTicket() {
        return ticket;
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

    public void setId(int num) {
        this.id = num;
    }

    public void setBalance(double num) {
        this.balance = num;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public ArrayList<String> printInfo() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(this.name);
        data.add(this.email);
        data.add(this.password);
        data.add(this.phoneNumber);
        data.add(String.valueOf(this.balance));
        data.add(String.valueOf(this.luggage));
        return data;

    }
}
