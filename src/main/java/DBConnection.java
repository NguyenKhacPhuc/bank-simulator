import java.sql.*;

public class DBConnection {
    public static void main(String[] args) throws SQLException {
        String DB_URL = "jdbc:mysql://localhost:3306/bank";
        String PASSWORD = "";
        String USER_NAME = "root";
        Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement statement = conn.createStatement();
    }

    public static Connection getConnection(String dbURL, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
