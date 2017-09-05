package Task7.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionImpl {
    private static Connection connection;

    private MySQLConnectionImpl() {
    }

    private void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String jdbcUrl = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";
        try {
            connection = DriverManager.getConnection(jdbcUrl, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null)
            new MySQLConnectionImpl().createConnection();
        return connection;
    }
}
