package dbStuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final static String HOST = "jdbc:mysql://localhost:3306/todolist";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "1152";
    private Connection connection;
    public DBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
//            if (!connection.isClosed()) {
//                System.out.println("We are connected!");
//            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("unhandled", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
