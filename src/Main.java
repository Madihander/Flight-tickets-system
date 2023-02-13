import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

public class Main {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "12345";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Flight_Tickets_System";
    static dbConnection db = new dbConnection();
    static Connection conn = db.connect_to_db(DB_URL, DB_USERNAME, DB_PASSWORD);
    private static final Admin admin = new Admin("John", "john@gmail.com", "+7767176639");
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        // Пример
        System.out.println(admin.getPassword());
        TableAirport tableAirport = db.getTableAirport();
        tableAirport.readData(conn);
        //создаем нового пользователя для проверки авторизации
        Customer newCustomer = new Customer("Valer", "asda", "+771231231");
        admin.addNewCustomer(newCustomer, conn);
        System.out.println("Name: " + newCustomer.getName());
        System.out.println("Name: " + newCustomer.getEmail());
        System.out.println("Name: " + newCustomer.getPhoneNumber());
        System.out.println("Password: " + newCustomer.getPassword());
        /*
        int option = 0;
        System.out.println("=== FLIGHT TICKET SYSTEM ===");
        System.out.println("=== CHOOSE OPTION ===");
        System.out.println("=== 1. SIGN UP === \n" + "=== 2. SIGN IN ===\n" + "=== 3. EXIT ===");
        option = scanner.nextInt();
        launch(option);*/
    }
    /*
    public static void launch(int option) throws SQLException {
        switch (option) {
            case 1 -> signUp();
            case 2 -> signIn();
            case 3 -> System.exit(0);
        }
    }

    public static void signUp() {

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
        // Создаем нового пользователя
        Customer newCustomer = new Customer(name, email, phoneNumber);
        newCustomer.setBalance(balance);
        // Добавляем его в базу
        admin.addNewCustomer(newCustomer, conn);

        System.out.println("=== Your password: " + newCustomer.getPassword() + " ===");
        System.out.println("=== NEW CUSTOMER CREATED ===");
        //userInterfase(newCustomer);
    }

    public static void signIn() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== SIGN IN ===");
        Customer customer = null;

        System.out.println("=== Enter your name ===");
        String name = scanner.next();

        System.out.println("=== Enter your password ===");
        String password = scanner.next();

        if (admin.getName().equals(name) && admin.getPassword().equals(password)) {
            adminInterfase();
        }

        ResultSet result = admin.findCustomer("asda", "13818382", conn);
        while (result.next()) {
            if (result.getString("name") == null) {
                System.out.println("You got a problem, try again");
                System.exit(0);
            } else {
                customer = new Customer(
                        result.getString("name"),
                        result.getString("email"),
                        result.getString("phonenumber"));
                customer.setPassword(result.getString("password"));
                customerInterfase(customer);
            }
        }
    }

    public static void customerInterfase(Customer customer) {
    }

    public static void adminInterfase() {
        int option = 0;
        System.out.println("=== ADMIN PANEL ===");
        System.out.println("=== 1. ADD AIRPORT ===");
        System.out.println("=== 2. DELETE AIRPORT ===");
        System.out.println("=== 3. ADD FLIGHT ===");
        System.out.println("=== 4. DELETE FLIGHT ===");
        System.out.println("=== 5. EXIT ===");
        option = scanner.nextInt();
        switch (option) {
            case 1 -> addAirport();
            case 2 -> deleteAirport();
            case 3 -> addFlight();
            case 4 -> deleteFlight();
            case 5 -> System.exit(0);
        }
    }
    public static void addAirport() {
        System.out.println("=== ADD AIRPORT ===");
        //Запрашиваем данные для создания нового класса
        System.out.println("=== ENTER TITLE ===");
        String title = scanner.next();

        System.out.println("=== ENTER LOCATION ===");
        String location = scanner.next();

        //Создаем класс и добавляем его в массив
        Airport newAirport = new Airport(title, location);
        admin.addNewAirport(newAirport, conn);
        adminInterfase();
    }
    public static void deleteAirport() {
        System.out.println("=== Choose id of Airport ===");
        admin.readAirports(conn);
        admin.deleteAirport(conn);
        adminInterfase();

    }
    public static void addFlight() {
        System.out.println("=== ADD FLIGHT ===");
        //Запрашиваем данные для создания нового класса
        System.out.println("=== ENTER NUMBER ===");
        int number = scanner.nextInt();

        System.out.println("=== ENTER LOCATION ===");
        String location = scanner.next();

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

        System.out.println("ENTER number of places");
        int numberPlaces = scanner.nextInt();
        int[] Places = new int[numberPlaces];
        for(int i = 0; i< numberPlaces; i++) {
            Places[i] = 0;
        }
        //Создаем класс и добавляем его в массив
        Flight newFlight = new Flight(
                number, location, departureDate, departure, arrival,
                startTime, endTime, cost, Places);
        admin.addNewFlight(newFlight, conn,location);
        adminInterfase();
    }
    public static void deleteFlight() {
        System.out.println("=== Choose id of Flight ===");
        admin.readFlight(conn);
        admin.deleteFlight(conn);
        adminInterfase();
    }*/
}