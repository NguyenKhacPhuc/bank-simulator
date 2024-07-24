package controller;

import data.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

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
        if(account.getBalance() > amount ){
            account.setBalance(account.getBalance() - amount); ;
            //update database with id of account
            System.out.println("Your balance is " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void transfer(double amount) {
        if(balance > amount) {
            this.balance -= amount;
        }
        //update database with id of account
        System.out.println("Transfer successful");
        System.out.println("Your balance is " + balance);
    }

    public void deposit(double amount) {
        if(amount > 0) {
            this.balance += amount;
        }
        System.out.println("Your balance is " + balance);
    }
}
