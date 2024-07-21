import java.sql.*;
import java.sql.Connection;

public class Create {
    public static void main(String[] args) throws SQLException {
        String DB_URL = "jdbc:mysql://localhost:3306/bank";
        String PASSWORD = "";
        String USER_NAME = "root";
        java.sql.Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement statement = conn.createStatement();
        // Customer
        String sqlCreateCustomer = "INSERT INTO `account` (`idAccount`, `userName`, `balance`, `accNumber`, `limitDayWithdrawal`, `password`, `idBank`) VALUES\n" +
                "(7, 'PHAM XUAN THUY', 7000, '0966238336', 10000, '123456', 1)";

        PreparedStatement ps = conn.prepareStatement(sqlCreateCustomer);
        ps.executeUpdate();
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
