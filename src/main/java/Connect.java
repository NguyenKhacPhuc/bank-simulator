import java.sql.*;

public class ConnectSQL {
    public static void main(String[] args) throws SQLException {
        String DB_URL = "jdbc:mysql://localhost:3306/my_db";
        String PASSWORD = "123456";
        String USER_NAME = "root";
        Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("select * from bank");
        while (result.next()) {
            System.out.println(result.getString(2) + " " + result.getString(3));
        }
    }
    public static Connection getConnection(String dbURL, String userName,
                                           String password) {
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

