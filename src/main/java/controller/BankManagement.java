package controller;

import data.Account;
import data.Customer;
import data.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

//Duc Anh
//Load data every time app start: transactions, customer, Accounts
//execute transaction: update balance of Account sender, account receiver, handle error...
public class BankManagement {
//    private TransactionManagement transactionManagement;
//
//    public BankManagement(TransactionManagement transactionManagement) {
//        this.transactionManagement = transactionManagement;
//    }

    public BankManagement() {

    }

    public void executeTransaction(TransactionManagement transactionManagement, Transaction transaction, Account sender, Account receiver, double amount, Connection connection) throws SQLException {
        double senderBalance = transactionManagement.getAccountBalance(sender.getAccountID(), connection);
        if (senderBalance > amount) {
            transactionManagement.executeTransaction(transaction, sender, receiver, amount, connection);
            System.out.println("Transaction completed successfully.");
        } else {
            System.out.println("Insufficient funds in sender's account.");
        }
    }

    public Customer getCustomerDetails(String customerId) {
        return null;
    }

    public Account getAccountDetails(int accountId) {
        return null;
    }

    public void addCustomer(Customer customer) {

    }

    public void addAccount(Account account) {

    }

    public void removeAccount(Account account) {

    }

    public void executeTransaction(Transaction transaction) {

    }


}
