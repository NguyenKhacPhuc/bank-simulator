package Bank;

import java.sql.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;

public class Create {
    public static void main(String[] args) {
        try {
            String DB_URL = "jdbc:mysql://localhost:3306/schema1";
            String PASSWORD = "phuc1213";
            String USER_NAME = "root";
            java.sql.Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            //createCustomer(conn, new Customer(6, "Nguyen Van K", 22, "Hue", 3));
            //createAccount(conn, new Account(5, 5000, "Nguyen Van K", "0966238399", 10000, "123456", 3));
            createTransaction(conn, new Transaction(2, 1, 1, "TRANSFERS", 200, "0966238315", "0966238336", new java.sql.Date(LocalDate.now().toEpochDay()), 6800, "Done"));
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public static void createCustomer(Connection conn, Customer customer) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("INSERT INTO `customer` (`idCustomer`, `name`, `age`, `address`, `idAccount`) VALUES(?, ?, ?, ?, ?)");
        statement.setInt(1, customer.getCustomerID());
        statement.setString(2, customer.getName());
        statement.setInt(3, customer.getAge());
        statement.setString(4, customer.getAddress());
        statement.setInt(5, customer.getAccountsID());
        statement.executeUpdate();
    }

    public static void createAccount(Connection conn, Account account) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("INSERT INTO `account` (`idAccount`, `userName`, `balance`, `accNumber`, `limitDayWithdrawal`, `password`, `idBank`) VALUES(?, ?, ?, ?, ?, ?, ?)");
        statement.setInt(1, account.getAccountID());
        statement.setString(2, account.getUserName());
        statement.setDouble(3, account.getBalance());
        statement.setString(4, account.getAccNumber());
        statement.setDouble(5, account.getLimitDayWithdrawal());
        statement.setString(6, account.getPassword());
        statement.setInt(7, account.getBankID());
        statement.executeUpdate();
    }

    public static void createTransaction(Connection conn, Transaction transaction) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("INSERT INTO `transaction` " +
                "(`idTransaction`, `senderAccountNumber`, `receiverAccountNumber`, `time`, `amountMoney`, `balanceAfterSend`, `message`, `transactionType`, `senderAccountId`, `receiverAccountId`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        statement.setInt(1, transaction.getTransactionId());
        statement.setString(2, transaction.getSenderAccountNumber());
        statement.setString(3, transaction.getReceiverAccountNumber());
        statement.setString(4, transaction.getTime().toString());
        statement.setDouble(5, transaction.getAmountMoney());
        statement.setDouble(6, transaction.getBalanceAfterSend());
        statement.setString(7, transaction.getMessage());
        statement.setString(8, transaction.getTransactionType());
        statement.setInt(9, transaction.getSenderAccountId());
        statement.setInt(10, transaction.getReceiverAccountId());
        statement.executeUpdate();
    }
}
