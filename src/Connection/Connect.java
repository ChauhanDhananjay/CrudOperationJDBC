package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/advjava";
    private static final String USERNAME = "jspider";
    private static final String PASSWORD = "jspider";

    // Private constructor (prevents object creation)
    private Connect() {
    }

    public static Connection createConnection() {
        Connection conn = null;

        try {

            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Database Connection Failed");
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
