package controller;

import data.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//Vinh
//handle error
//finish
public class AccountManagement {
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

    public void deleteAccount(Connection conn, Account account) throws SQLException {
        System.out.println("Inside delete");
        System.out.println("1. Delete with account id");
        System.out.println("2. Delete with account number");
        System.out.println();
        switch (new Scanner(System.in).nextInt()) {
            case 1: {
                System.out.println("Enter id account you want to delete: ");
                account.setAccountID(new Scanner(System.in).nextInt());
                PreparedStatement statement = conn.prepareStatement("DELETE FROM `schema1`.`account` WHERE (`idAccount` = '" + account.getAccountID() + "');");

                if (statement.executeUpdate() < 0) {
                    System.out.println("Delete unsuccessfull");
                }
                break;
            }
            case 2: {
                System.out.println("Enter number of account you want to delete: ");
                account.setAccNumber(new Scanner(System.in).nextLine());
                PreparedStatement statement2 = conn.prepareStatement("DELETE FROM `schema1`.`account` WHERE (`accNumber` = '" + account.getAccNumber() + "');");

                if (statement2.executeUpdate() < 0) {
                    System.out.println("Delete unsuccessfull");
                }
                break;
            }
            default:
                System.out.println("Dont have your choice");
                break;
        }
    }

    public List<Account> getAllAccounts(Connection conn) throws SQLException {
        List<Account> accounts = new ArrayList<>();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM `account`");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Account account = new Account(rs.getInt("idAccount"), rs.getString("userName"), rs.getDouble("balance"),
                    rs.getString("accNumber"), rs.getDouble("limitDayWithdrawal"), rs.getString("password"), rs.getInt("idBank"));
            accounts.add(account);
        }
        return accounts;
    }

    public void executeWithdraw(Account account, double amount, Connection conn) throws SQLException {
        try {
            if (amount > 0 && account.getBalance() >= amount) {
                String query = "UPDATE account SET balance = balance - ? WHERE idAccount = ?;";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setDouble(1, amount);
                statement.setInt(2, account.getBankID());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Error in executeTransaction: " + e);
        }
    }

    public void executeDeposit(Account account, double amount, Connection conn) throws SQLException {
        try {
            if (amount > 0) {
                String query = "UPDATE account SET balance = balance + ? WHERE idAccount = ?;";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setDouble(1, amount);
                statement.setInt(2, account.getBankID());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Error in executeTransaction: " + e);
        }
    }

    public List<Account> getAllAccount() {
        return null;
    }

}
