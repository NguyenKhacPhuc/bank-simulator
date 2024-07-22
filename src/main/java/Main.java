import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String DB_URL = "jdbc:mysql://localhost:3306/bank";
        final String PASSWORD = "";
        final String USER_NAME = "root";

        Transaction transactionDB = new Transaction();
        Customer customerDB = new Customer();
        Account accountDB = new Account();

        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement statement = conn.createStatement();

            System.out.println("Enter your choice");
            System.out.println("1. Delete Transaction");
            System.out.println("2. Delete Customer");
            System.out.println("3. Delete Account");

            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    deleteTransaction(conn, transactionDB);
                    break;
                case 2:
                    deleteCustomer(conn, customerDB);
                    break;
                case 3:
                    deleteAccount(conn, accountDB);
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

    public static void deleteTransaction(Connection conn, Transaction trans) throws SQLException {
        System.out.println("Inside delete");
        System.out.println("Enter id transaction you want to delete: ");
        trans.setTransactionId(new Scanner(System.in).nextInt());
        PreparedStatement statement = conn.prepareStatement("DELETE FROM `bank`.`transaction` WHERE (`idTransaction` = '" + trans.getTransactionId() + "');");
        int roww = statement.executeUpdate();

        if (roww < 0) {
            System.out.println("Delete unsuccessfull");
        }
    }

    public static void deleteCustomer(Connection conn, Customer customer) throws SQLException {
        System.out.println("Inside delete");
        System.out.println("Enter id customer you want to delete: ");
        int id;
        customer.setCustomerID(id = new Scanner(System.in).nextInt());
        PreparedStatement statement = conn.prepareStatement("DELETE FROM `bank`.`customer` WHERE (`idCustomer` = '" + customer.getCustomerID() + "');");
        int roww = statement.executeUpdate();
        if (roww < 0) {
            System.out.println("Delete unsuccessfull");
        }
    }

    public static void deleteAccount(Connection conn, Account account) throws SQLException {
        System.out.println("Inside delete");
        System.out.println("1. Delete with account id");
        System.out.println("2. Delete with account number");
        System.out.println();
        switch (new Scanner(System.in).nextInt()) {
            case 1:
                System.out.println("Enter id account you want to delete: ");
                account.setAccountID(new Scanner(System.in).nextInt());
                PreparedStatement statement = conn.prepareStatement("DELETE FROM `bank`.`account` WHERE (`idAccount` = '" + account.getAccountID() + "');");
//                int row1 = statement.executeUpdate();

                if (statement.executeUpdate() < 0) {
                    System.out.println("Delete unsuccessfull");
                }
                break;
            case 2:
                System.out.println("Enter number of account you want to delete: ");
                account.setAccNumber(new Scanner(System.in).nextLine());
                PreparedStatement statement2 = conn.prepareStatement("DELETE FROM `bank`.`account` WHERE (`accNumber` = '" + account.getAccNumber() + "');");
//                int row2 = statement.executeUpdate();

                if (statement2.executeUpdate() < 0) {
                    System.out.println("Delete unsuccessfull");
                }
                break;
            default:
                System.out.println("Dont have your choice");
                break;
        }
    }
}