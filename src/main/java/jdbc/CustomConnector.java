package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomConnector {
    private final ResourceBundle rb = ResourceBundle.getBundle("app");

    public Connection getConnection() {
        try {
            Class.forName(rb.getString("postgres.driver"));
            return DriverManager.getConnection(rb.getString("postgres.url"),
                    rb.getString("postgres.name"), rb.getString("postgres.password"));
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection(String url, String user, String password) {
        try {
            Class.forName(rb.getString("postgres.driver"));
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException();
        }
    }
}
