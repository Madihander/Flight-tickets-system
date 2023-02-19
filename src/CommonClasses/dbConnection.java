package CommonClasses;

import java.sql.*;

public class dbConnection {
    public static dbConnection instance;
    private Connection connection;
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "12345";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Flight_Ticket_System2";

    // Используем паттерн синглтон
    // Создаем класс, у которого отстувует конструктор
    // чтобы создать экземпляр класса - используем метод

    // Подключаемся к базе данных
    private dbConnection() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Drivers is not found");
            e.printStackTrace();
        }

        System.out.println("PostgreSQL JDBC Drivers successfully connected");

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
    }

    // Получить connection
    public Connection getConnection() {
        return connection;
    }

    // Получить экземпляр класса
    public static dbConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new dbConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new dbConnection();
        }
        return instance;
    }
}
