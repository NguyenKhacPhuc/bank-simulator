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

    public void executeTransaction(TransactionManagement transactionManagement, Transaction transaction, int senderID, int receiverid, double amount,String message, Connection connection) throws SQLException {
//        double senderBalance = transactionManagement.getAccountBalance(sender.getAccountID(), connection);

        Account sender = getAccountDetails(senderID, connection);
        Account receiver = getAccountDetails(receiverid, connection);
        if (sender != null && receiver != null && sender.getBalance() > amount) {
            transactionManagement.executeTransaction(transaction, sender, receiver, amount,message, connection);
            System.out.println("Transaction completed successfully.");
        } else {
            System.out.println("Fail to transfer transaction. Please check your account balance.");
        }
    }

    public Customer getCustomerDetails(int customerID, Connection connection) {
        String qr = "SELECT * FROM `customer` WHERE idCustomer = ?";
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
        String qr = "SELECT * FROM account WHERE idAccount = ?";
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
                int idBank = rs.getInt("idBank");

                account = new Account(idAccount, userName, balance, accNumber, limitDayWithdrawal, password, idBank);
            }
        } catch (SQLException e) {
            System.out.println("Fail to get account details :" + e);
        }
        return account;
    }

    public void addCustomer(Connection conn, Customer customer) throws SQLException {
        System.out.println("add customer");
        PreparedStatement statement = conn.prepareStatement("INSERT INTO `customer` (`idCustomer`, `name`, `age`, `address`, `idAccount`) VALUES(?, ?, ?, ?, ?)");
        customer.setCustomerID(new Scanner(System.in).nextInt());
        statement.setInt(1, customer.getCustomerID());
        customer.setName(new Scanner(System.in).nextLine());
        statement.setString(2, customer.getName());
        customer.setAge(new Scanner(System.in).nextInt());
        statement.setInt(3, customer.getAge());
        customer.setAddress(new Scanner(System.in).nextLine());
        statement.setString(4, customer.getAddress());
        customer.setAccountsID(new Scanner(System.in).nextInt());
        statement.setInt(5, customer.getAccountsID());
        statement.executeUpdate();
    }

    public void addAccount(Connection conn, Account account) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("INSERT INTO `account` (`idAccount`, `userName`, `balance`, `accNumber`, `limitDayWithdrawal`, `password`, `idBank`) VALUES(?, ?, ?, ?, ?, ?, ?)");
        account.setAccountID(new Scanner(System.in).nextInt());
        statement.setInt(1, account.getAccountID());
        account.setUserName(new Scanner(System.in).nextLine());
        statement.setString(2, account.getUserName());
        account.setBalance(new Scanner(System.in).nextDouble());
        statement.setDouble(3, account.getBalance());
        account.setAccNumber(new Scanner(System.in).nextLine());
        statement.setString(4, account.getAccNumber());
        account.setLimitDayWithdrawal(new Scanner(System.in).nextDouble());
        statement.setDouble(5, account.getLimitDayWithdrawal());
        account.setPassword(new Scanner(System.in).nextLine());
        statement.setString(6, account.getPassword());
        account.setBankID(new Scanner(System.in).nextInt());
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
        PreparedStatement statement = conn.prepareStatement("DELETE FROM `customer` WHERE (`idCustomer` = '" + customer.getCustomerID() + "');");
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
        PreparedStatement statement = conn.prepareStatement("DELETE FROM `account` WHERE (`idAccount` = '" + account.getAccountID() + "');");
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