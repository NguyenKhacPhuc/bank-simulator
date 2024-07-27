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
                PreparedStatement statement = conn.prepareStatement(
                        "DELETE FROM `schema1`.`account` WHERE (`idAccount` = '" + account.getAccountID() + "');");

                if (statement.executeUpdate() < 0) {
                    System.out.println("Delete unsuccessfull");
                }
                break;
            }
            case 2: {
                System.out.println("Enter number of account you want to delete: ");
                account.setAccNumber(new Scanner(System.in).nextLine());
                PreparedStatement statement2 = conn.prepareStatement(
                        "DELETE FROM `schema1`.`account` WHERE (`accNumber` = '" + account.getAccNumber() + "');");

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
        try {
            if (account.getBalance() > amount) {
                account.setBalance(account.getBalance() - amount);
                System.out.println("Withdrawal sucessfully. New Balance :  "+account.getBalance());
            } else {
                throw new IllegalArgumentException("Insufficient balance or invalid amount.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Withdrawal failed");
        }
    }

    public void transfer(Account fromAccount,Account toAccount, double amount) {

        try{
            if (amount > 0 && amount <= fromAccount.getBalance()) {
                withdraw(fromAccount, amount);
                deposit(toAccount, amount);
                System.out.println("Transfer successful. New balance of source account: " + fromAccount.getBalance());
                System.out.println("New balance of destination account: " + toAccount.getBalance());
            } else {
                throw new IllegalArgumentException("Invalid transfer");            }
        }
        catch (IllegalArgumentException e) {
              System.out.println("Transfer Failed: ");
        }
    }

    public void deposit(Account account, double amount) {
       try {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
       } catch (IllegalArgumentException e) {
             System.out.println("Deposit failed");
       }
    }

    public List<Account> getAllAccount() {
        return null;
    }
}
