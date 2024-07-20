import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String DB_URL = "jdbc:mysql://localhost:3306/bank";
        final String PASSWORD = "";
        final String USER_NAME = "root";

        Transaction transactionDB = new Transaction();
        transactionDB.setTransactionId(3);

        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement statement = conn.createStatement();

            System.out.println("Enter your choice");
            System.out.println("1. Delete with Transaction ID");

            int choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1:
                delete(conn,transactionDB );
                    break;

                default:
                    break;
            }
        } catch (SQLException e) {
            System.out.println("Have SQLException");
        }
    }

    public static Connection getConnection(String dbURL, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("Connect successfully!");
        } catch (Exception ex) {
            System.out.println("Connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    public static void delete(Connection conn, Transaction trans) throws SQLException {
        System.out.println("Inside delete");
        PreparedStatement statement = conn.prepareStatement("DELETE FROM `bank`.`transaction` WHERE (`idTransaction` = '"+trans.getTransactionId()+"');");
        int roww = statement.executeUpdate();

        if (roww < 0) {
            System.out.println("Delete unsuccessfull");
        }
    }
}
