import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
    public static void main(String[] args) throws SQLException {
        String DB_URL = "jdbc:mysql://localhost:3306/bank";
        String PASSWORD = "";
        String USER_NAME = "root";
        java.sql.Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("Select * from Bank");
    }

    public static java.sql.Connection getConnection(String dbURL, String userName,
                                                    String password) {
        java.sql.Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}
