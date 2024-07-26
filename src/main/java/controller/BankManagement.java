package controller;

import data.Account;
import data.Customer;
import data.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

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

    public Customer getCustomerDetails(int customerID, Connection connection) {
        String qr = "SELECT * FROM `bank.customer` WHERE idCustomer = ?";
        Customer customer = null;
        try {
            PreparedStatement statement = connection.prepareStatement(qr);
            statement.setInt(1, customerID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int idCustomer = rs.getInt("idCustomer");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                int idAccount = rs.getInt("idAccount");
                customer = new Customer(idCustomer, name, age, address, idAccount);
            }
        } catch (SQLException e) {
            System.out.println("Fail to get customer details :" + e);
        }
        return customer;
    }

    public Account getAccountDetails(int accountID, Connection connection) {
        String qr = "SELECT `*` FROM `bank.account` WHERE idAccount = ?";
        Account account = null;
        try {
            PreparedStatement statement = connection.prepareStatement(qr);
            statement.setInt(1, accountID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int idAccount = rs.getInt("idAccount");
                String userName = rs.getString("userName");
                double balance = rs.getDouble("balance");
                String accNumber = rs.getString("accNumber");
                double limitDayWithdrawal = rs.getDouble("limitDayWithdrawal");
                String password = rs.getString("password");
                int bankID = rs.getInt("bankID");

                account = new Account(idAccount, userName, balance, accNumber, limitDayWithdrawal, password, bankID);
            }
        } catch (SQLException e) {
            System.out.println("Fail to get customer details :" + e);
        }
        return account;
    }

    public static void addCustomer(Connection conn, Customer customer) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("INSERT INTO `customer` (`idCustomer`, `name`, `age`, `address`, `idAccount`) VALUES(?, ?, ?, ?, ?)");
        statement.setInt(1, customer.getCustomerID());
        statement.setString(2, customer.getName());
        statement.setInt(3, customer.getAge());
        statement.setString(4, customer.getAddress());
        statement.setInt(5, customer.getAccountsID());
        statement.executeUpdate();
    }

    public static void addAccount(Connection conn, Account account) throws SQLException {
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

//    public void addAccount(Account account, Connection connection) {
//
//    }

//    public void removeAccount(Account account, Connection connection) {
//
//    }
//
//    public void removeCustomer(Account account, Connection connection) {
//
//    }

    public void removeCustomer(Customer customer, Connection conn) throws SQLException {
        customer.setCustomerID(new Scanner(System.in).nextInt());
        PreparedStatement statement = conn.prepareStatement("DELETE FROM `bank`.`customer` WHERE (`idCustomer` = '" + customer.getCustomerID() + "');");
        int roww = statement.executeUpdate();
        if (roww < 0) {
            System.out.println("Delete unsuccessfully");
        }
    }

    public void removeAccount(Account account, Connection conn) throws SQLException {
//        System.out.println("Inside delete");
//        System.out.println("1. Delete with account id");
//        System.out.println("2. Delete with account number");
//        System.out.println();
//        switch (new Scanner(System.in).nextInt()) {
//            case 1: {
//                System.out.println("Enter id account you want to delete: ");
//                account.setAccountID(new Scanner(System.in).nextInt());
        PreparedStatement statement = conn.prepareStatement("DELETE FROM `schema1`.`account` WHERE (`idAccount` = '" + account.getAccountID() + "');");
        if (statement.executeUpdate() < 0) {
            System.out.println("Delete unsuccessfull");
        }
//                break;
//            }
//            case 2: {
//                System.out.println("Enter number of account you want to delete: ");
//                account.setAccNumber(new Scanner(System.in).nextLine());
//                PreparedStatement statement2 = conn.prepareStatement("DELETE FROM `schema1`.`account` WHERE (`accNumber` = '" + account.getAccNumber() + "');");
//                if (statement2.executeUpdate() < 0) {
//                    System.out.println("Delete unsuccessfull");
//                }
//                break;
//            }
//            default:
//                System.out.println("Dont have your choice");
//                break;
//        }
    }
}
