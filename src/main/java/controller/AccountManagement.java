package controller;

import data.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


//Vinh
//handle error
//finish
public class AccountManagement {
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

    public void withdraw(Account account, double amount) {

    }

    public void transfer(double amount) {

    }

    public void deposit(double amount) {

    }

    public List<Account> getAllAccount() {
        return null;
    }
}
