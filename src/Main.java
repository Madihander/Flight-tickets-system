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
        Admin admin = new Admin("John", new InsertCommand(DB), new ReadCommand(DB), new FindCommand(DB), new DeleteCommand(DB));

        System.out.println("=== admin password: " + admin.getPassword() + " === \n");


        //Airport airport = new Airport("Asan", "Asan");
        //int id = 0;
        //result = admin.insertRecord(airport, "airports");
        //while (result.next()) {
        //    id = result.getInt("id");
        //}
        //System.out.println(id);

        /*admin.delete.execute(null,"airports");
        result = admin.read.execute(null,"airports");
        while (result.next()) {
            System.out.print(result.getString("id") + "| ");
            System.out.print(result.getString("title") + "| ");
            System.out.println(result.getString("location") + "| ");
        }*/

        //Flight flight = new Flight(airport.getIdAirport(), "2023-02-10", "Karaganda",
        //        "01:20:00", "03:40:00", 1000, 50);
        //String FlightID = admin.insertRecord(flight, "flights");
        //flight.setId(Integer.parseInt(FlightID));
        //System.out.println(FlightID);


        //Customer customer = new Customer("Alik","ALik@mail.ru","+ALik");

        //String id = admin.insertRecord(customer,"customers");
        //customer.setId(Integer.parseInt(id));

        //Ticket ticket = new Ticket(customer.getId(),601,1,1000);
        //String idTIC = admin.insertRecord(ticket,"tickets");
        //ticket.setIdTicket(Integer.parseInt(idTIC));

        //Passenger passenger =new Passenger(0.5,0.5,ticket.getIdTicket());
        //String idPAs = admin.insertRecord(passenger,"passengers");
        //System.out.println(idPAs);


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
        // Создаем нового пользователя
        CommonClasses.Customer newCustomer = new CommonClasses.Customer(name, email, phoneNumber);
        newCustomer.setBalance(balance);
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

        СommonClass query = new QueryFind(str, name, password,phonenumber);
        ResultSet result = admin.find.execute(query, "customers");
        while (result.next()) {
            if (result.getString("name") == null) {
                System.out.println("You got a problem, try again");
                System.exit(0);
            } else {
                customer = new CommonClasses.Customer(
                        result.getString("name"),
                        result.getString("email"),
                        result.getString("phonenumber"));
                customer.setPassword(result.getString("password"));
                customer.setId(result.getInt("id"));
                customerInterfase(customer,admin);
            }
        }
    }

    public static void customerInterfase(CommonClasses.Customer customer, Admin admin) {
        System.out.println("YOU CUSTOMER");
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
            case 1 -> addAirport(admin);
            case 2 -> deleteAirport(admin);
            case 3 -> addFlight(admin);
            case 4 -> deleteFlight(admin);
            case 5 -> System.exit(0);
        }
    }

    public static void addAirport(Admin admin) throws SQLException {
        System.out.println("=== ADD AIRPORT ===");
        //Запрашиваем данные для создания нового класса
        System.out.println("=== ENTER TITLE ===");
        String title = scanner.next();

        System.out.println("=== ENTER LOCATION ===");
        String location = scanner.next();

        //Создаем класс и добавляем его в массив
        Airport newAirport = new Airport(title,location);
        ResultSet result = admin.insert.execute(newAirport,"airports");
        int id = ReachIdFromResultSet(result);
        newAirport.setIdAirport(id);

        adminInterfase(admin);
    }

    public static void deleteAirport(Admin admin) throws SQLException {
        System.out.println("=== DELETE AIRPORT ===");
        System.out.println("=== CHOOSE ID ===");
        ResultSet result = null;
        result = admin.read.execute(null, "airports");
        while (result.next()) {
            System.out.print(result.getString("id") + "| ");
            System.out.print(result.getString("title") + "| ");
            System.out.println(result.getString("location") + "| ");
        }
        admin.delete.execute(null,"airports");

        adminInterfase(admin);

    }

    public static void addFlight(Admin admin) throws SQLException {
        System.out.println("=== CHOSE ID AIRPORT ===");
        ResultSet result = admin.read.execute(null, "airports");
        while (result.next()) {
            System.out.print(result.getString("id") + "| ");
            System.out.print(result.getString("title") + "| ");
            System.out.println(result.getString("location") + "| ");
        }
        System.out.println("=== ENTER ID ===");
        int locationAirport = scanner.nextInt();

        System.out.println("=== ADD FLIGHT ===");
        //Запрашиваем данные для создания нового класса

        System.out.println("=== ENTER departureDate ===");
        String departureDate = scanner.next();

        System.out.println("=== ENTER arrival ===");
        String arrival = scanner.next();

        System.out.println("=== ENTER startTime ===");
        String startTime = scanner.next();

        System.out.println("=== ENTER endTime ===");
        String endTime = scanner.next();

        System.out.println("=== ENTER cost ===");
        int cost = scanner.nextInt();

        System.out.println("ENTER number of places");
        int Places = scanner.nextInt();
        //Создаем класс и добавляем его в массив
        CommonClasses.Flight newFlight = new CommonClasses.Flight(
                locationAirport, departureDate, arrival, startTime, endTime, cost, Places);
        admin.insert.execute(newFlight,"flights");

        adminInterfase(admin);
    }

    public static void deleteFlight(Admin admin) {
        System.out.println("=== Choose id of CommonClasses.Flight ===");
        admin.readFlight(conn);
        admin.deleteFlight(conn);
        adminInterfase();
    }

    public static int ReachIdFromResultSet(ResultSet result) throws SQLException {
        int id =0;
        while (result.next()) {
            id = result.getInt("id");
        }
        return id;
    }

}