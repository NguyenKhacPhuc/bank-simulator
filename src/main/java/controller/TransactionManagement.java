package controller;

import data.Account;
import data.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

//update fields
//get
public class TransactionManagement {
    public void deleteTransaction(Connection conn, Transaction trans) throws SQLException {
        System.out.println("Inside delete");
        System.out.println("Enter id transaction you want to delete: ");
        trans.setTransactionId(new Scanner(System.in).nextInt());
        PreparedStatement statement = conn.prepareStatement("DELETE FROM `schema1`.`transaction` WHERE (`idTransaction` = '" + trans.getTransactionId() + "');");
        int roww = statement.executeUpdate();
        if (roww < 0) {
            System.out.println("Delete unsuccessfull");
        }
    }

    public List<Transaction> getAllTransaction(Connection conn) throws SQLException {

        return null;
    }

    public void executeTransaction(Transaction transaction, Account sender, Account receiver, double amount, Connection connection) throws SQLException {
        try {
            String query = "BEGIN; " +
                    "UPDATE `bank`.`account` SET `balance` = `balance` - ? WHERE `idAccount` = ?; " +
                    "UPDATE `bank`.`account` SET `balance` = `balance` + ? WHERE `idAccount` = ?; " +
                    "INSERT INTO `bank`.`transaction` (`idTransaction`, `senderAccountNumber`, `receiverAccountNumber`, `time`, `amountMoney`, `balanceAfterSend`, `message`, `transactionType`, `senderAccountId`, `receiverAccountId`)" +
                    "(?, ?, ?,?,?,?,?,?,?,?); " +
                    "COMMIT;";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(1, amount);
            statement.setInt(2, sender.getAccountID());
            statement.setDouble(3, amount);
            statement.setInt(4, receiver.getAccountID());

            statement.setInt(5, transaction.getTransactionId());
            statement.setString(6, sender.getAccNumber());
            statement.setString(7, receiver.getAccNumber());
            statement.setString(8, transaction.getTime());
            statement.setDouble(9, amount);
            statement.setDouble(10, sender.getBalance() - amount);
            statement.setString(11, transaction.getMessage());
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
