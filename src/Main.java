import CommonClasses.*;
import CommonClasses.СommonClass;
import Tables.DataBase;
import org.checkerframework.checker.units.qual.A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        Connection conn;
        DataBase DB = new DataBase();
        ResultSet result;
        Admin admin = new Admin("John", new InsertCommand(DB), new ReadCommand(DB), new FindCommand(DB), new UpdateCommand(DB), new DeleteCommand(DB));
        System.out.println("=== admin password: " + admin.getPassword() + " === \n");
        int option = 0;
        System.out.println("=== FLIGHT TICKET SYSTEM ===");
        System.out.println("=== CHOOSE OPTION ===");
        System.out.println("=== 1. SIGN UP === \n" + "=== 2. SIGN IN ===\n" + "=== 3. EXIT ===");
        option = scanner.nextInt();
        launch(option, admin);
    }

    public static void launch(int option, Admin admin) throws SQLException {
        switch (option) {
            case 1 -> signUp(admin);
            case 2 -> signIn(admin);
            case 3 -> System.exit(0);
        }
    }

    public static void signUp(Admin admin) throws SQLException {

        System.out.println("\n=== SIGN UP ===");

        // Запрашиваем имя
        System.out.println("=== Enter your name ===");
        String name = scanner.next();

        // Запрашиваем почту
        System.out.println("=== Enter your email ===");
        String email = scanner.next();

        // Запрашиваем номер телефона
        System.out.println("=== Enter your phone number ===");
        String phoneNumber = scanner.next();

        // Запрашиваем пополнение баланса
        // цикл стоит, чтобы не поставили отрицательное значение баланса
        double balance = 0;
        int i = 1;
        while (i != 0) {
            System.out.println("=== Add balance ===");
            balance = scanner.nextInt();
            if (balance < 0) {
                System.out.println("=== Balance can't be negative===");
            } else {
                i = 0;
            }
        }

        System.out.println("=== Enter weight of luggage ===");
        double luggage = scanner.nextDouble();
        // Создаем нового пользователя
        CommonClasses.Customer newCustomer = new CommonClasses.Customer(name, email, phoneNumber,balance,luggage);
        // Добавляем его в базу

        ResultSet result = admin.insert.execute(newCustomer, "customers");

        int id = 0;
        while (result.next()) {
            id = result.getInt("id");
        }
        newCustomer.setId(id);

        System.out.println("=== Your password: " + newCustomer.getPassword() + " ===");
        System.out.println(newCustomer.getId());
        System.out.println("=== NEW CUSTOMER CREATED ===");
        //userInterfase(newCustomer);
    }

    public static void signIn(Admin admin) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== SIGN IN ===");
        CommonClasses.Customer customer = null;

        System.out.println("=== Enter your name ===");
        String name = scanner.next();

        System.out.println("=== Enter your password ===");
        String password = scanner.next();

        System.out.println("=== Enter your phone number ===");
        String phonenumber = scanner.next();

        if (admin.getName().equals(name) && admin.getPassword().equals(password)) {
            adminInterfase(admin);
        }
        String str = "SELECT * FROM %s WHERE name = '%s' AND password = '%s' AND phonenumber = '%s' ";

        СommonClass query = new QueryFind(str, name, password, phonenumber);
        ResultSet result = admin.find.execute(query, "customers");
        while (result.next()) {
            if (result.getString("name") == null) {
                System.out.println("You got a problem, try again");
                System.exit(0);
            } else {
                customer = new CommonClasses.Customer(
                        result.getString("name"),
                        result.getString("email"),
                        result.getString("phonenumber"),
                        result.getDouble("balance"),
                        result.getDouble("luggage"));
                customer.setPassword(result.getString("password"));
                customer.setId(result.getInt("id"));
                customer.setTicket(result.getInt("ticket"));
                customerInterfase(customer, admin);
            }
        }
    }

    public static void customerInterfase(CommonClasses.Customer customer, Admin admin) throws SQLException {
        int option = 0;
        System.out.println("=== CUSTOMER PANEL ===");
        System.out.println("=== 1. BUY TICKETS ===");
        System.out.println("=== 2. EXIT ===");
        option = scanner.nextInt();
        switch (option) {
            case 1 -> addTicket(customer, admin);
            case 2 -> System.exit(0);
        }
    }

    public static void adminInterfase(Admin admin) throws SQLException {
        int option = 0;
        System.out.println("=== ADMIN PANEL ===");
        System.out.println("=== 1. ADD AIRPORT ===");
        System.out.println("=== 2. DELETE AIRPORT ===");
        System.out.println("=== 3. ADD FLIGHT ===");
        System.out.println("=== 4. DELETE FLIGHT ===");
        System.out.println("=== 5. EXIT ===");
        option = scanner.nextInt();
        switch (option) {
            case 1 -> addFlight(admin);
            case 2 -> deleteFlight(admin);
            case 3 -> System.exit(0);
        }
    }

    public static void addFlight(Admin admin) throws SQLException {

        System.out.println("=== ADD FLIGHT ===");
        //Запрашиваем данные для создания нового класса

        System.out.println("=== ENTER departureDate ===");
        String departureDate = scanner.next();

        System.out.println("=== ENTER departure ===");
        String departure = scanner.next();

        System.out.println("=== ENTER arrival ===");
        String arrival = scanner.next();

        System.out.println("=== ENTER startTime ===");
        String startTime = scanner.next();

        System.out.println("=== ENTER endTime ===");
        String endTime = scanner.next();

        System.out.println("=== ENTER cost ===");
        int cost = scanner.nextInt();

        //Создаем класс и добавляем его в массив
        CommonClasses.Flight newFlight = new CommonClasses.Flight(
                departureDate, departure , arrival, startTime, endTime, cost);
        admin.insert.execute(newFlight, "flights");

        adminInterfase(admin);
    }

    public static void deleteFlight(Admin admin) throws SQLException {
        System.out.println("=== DELETE FLIGHT ===");
        System.out.println("=== CHOOSE ID ===");
        ResultSet result = null;
        result = admin.read.execute(null, "flights");
        while (result.next()) {
            System.out.print(result.getString("id") + "| ");
            System.out.println(result.getString("departure" + "| "));
            System.out.print(result.getString("arrival") + "| ");
            System.out.println(result.getString("starttime") + "| ");
            System.out.println(result.getString("endtime") + "| ");
        }
        admin.delete.execute(null, "flights");

        adminInterfase(admin);
    }


    public static void addTicket(CommonClasses.Customer customer, Admin admin) throws SQLException {

        System.out.println("=== BUY TICKET ===");
        System.out.println("=== CHOOSE FLIGHT ===");
        ResultSet result = null;
        result = admin.read.execute(null, "flights");
        while (result.next()) {
            System.out.print(result.getString("id") + "| ");
            System.out.print(result.getString("arrival") + "| ");
            System.out.println(result.getString("starttime") + "| ");
            System.out.println(result.getString("endtime") + "| ");
            System.out.println(result.getString("places") + "| ");
        }
        System.out.println("=== ENTER number flight ===");
        int numberFlight = scanner.nextInt();
        System.out.println("=== ENTER PLACE ===");
        int place = scanner.nextInt();
        System.out.println("=== ENTER PRICE ===");
        int price = scanner.nextInt();

        Ticket newTicket = new Ticket(customer.getId(), place, numberFlight, price);
        result = admin.insert.execute(newTicket, "tickets");
        int ticketId = 0;
        while (result.next()) {
            ticketId = result.getInt("id");
        }
        newTicket.setIdTicket(ticketId);
        System.out.println("\n=== ENTER LUGGAGE ===");
        double luggage = scanner.nextDouble();
        System.out.println("=== ENTER EXTRA LUGGAGE ===");
        double extraLuggage = scanner.nextDouble();

        Passenger newPassenger = new Passenger(luggage,extraLuggage,ticketId);
        admin.insert.execute(newPassenger,"passengers");
        adminInterfase(admin);
    }


    public static int ReachIdFromResultSet(ResultSet result) throws SQLException {
        int id = 0;
        while (result.next()) {
            id = result.getInt("id");
        }
        return id;
    }

}