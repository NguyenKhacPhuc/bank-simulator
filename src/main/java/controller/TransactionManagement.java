package controller;

import data.Account;
import data.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//update fields
//get
public class TransactionManagement {

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

    public void deleteTransaction(Connection conn, Transaction trans) throws SQLException {
        System.out.println("Inside delete");
        System.out.println("Enter id transaction you want to delete: ");
        trans.setTransactionId(new Scanner(System.in).nextInt());
        PreparedStatement statement = conn.prepareStatement("DELETE FROM `bank`.`transaction` WHERE (`idTransaction` = '" + trans.getTransactionId() + "');");
        int roww = statement.executeUpdate();

        if (roww < 0) {
            System.out.println("Delete unsuccessfull");
        }
    }
    public List<Transaction> getAllTransaction(Connection conn) throws SQLException {
        //get all transaction in db
        List<Transaction> transactions = new ArrayList<>();
        PreparedStatement statement = conn.prepareStatement("Select * from transaction");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Transaction transaction = new Transaction(rs.getInt("idTransaction"), rs.getInt("senderAccountId"),
                    rs.getInt("receiverAccountId"), rs.getString("transactionType"), rs.getDouble("amountMoney"),
                    rs.getString("receiverAccountNumber"), rs.getString("senderAccountNumber"),
                    rs.getString("time"), rs.getDouble("balanceAfterSend"), rs.getString("message"));
            transactions.add(transaction);
        }
        return transactions;
    }

        public void executeTransaction(Transaction transaction, Account sender, Account receiver, double amount,String message, Connection connection) throws SQLException {
        System.out.println("Starting transaction");
        try {
            String query = "BEGIN; " +
                    "UPDATE account SET balance = balance - ? WHERE idAccount = ?; " +
                    "UPDATE account SET balance = balance + ? WHERE idAccount = ?; " +
                    "INSERT INTO transaction (idTransaction, senderAccountNumber,receiverAccountNumber, time, amountMoney,balanceAfterSend,message, transactionType, senderAccountId, receiverAccountId)" +
                    "values (?,?,?,?,?,?,?,?,?,?); " +
                    "COMMIT;";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(1, amount);
//            transaction.setSenderAccountId(new Scanner(System.in).nextInt());
            statement.setInt(2, sender.getAccountID());
            statement.setDouble(3, amount);
//            transaction.setSenderAccountId(new Scanner(System.in).nextInt());
            statement.setInt(4, receiver.getAccountID());

            statement.setInt(5, transaction.getTransactionId());
            statement.setString(6, sender.getAccNumber());
            statement.setString(7, receiver.getAccNumber());
            statement.setString(8, transaction.getTime());
            statement.setDouble(9, amount);
            statement.setDouble(10, sender.getBalance() - amount);
            statement.setString(11, message);
            statement.setString(12, "TRANSFER");
            statement.setInt(13, sender.getAccountID());
            statement.setInt(14, receiver.getAccountID());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in executeTransaction: " + e);
        }

    }

    public double getAccountBalance(int accountID, Connection connection) throws SQLException {
        String qr = "SELECT balance FROM account WHERE idAccount = ?";
        PreparedStatement statement = connection.prepareStatement(qr);
        statement.setInt(1, accountID);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getDouble("balance");
        }
        return 0.0;
    }

}
