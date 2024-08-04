import controller.AccountManagement;
import controller.BankManagement;
import controller.CustomerManagement;
import controller.TransactionManagement;
import data.Account;
import data.Bank;
import data.Customer;
import data.Transaction;
import mysqldatabase.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

//Quân
public class Main {
    public static void main(String[] args) throws SQLException {
        //khởi tạo
        Transaction transaction = new Transaction();
        Customer customer = new Customer();
        Account account = new Account();
        Account account1 = new Account();

        TransactionManagement transactionManagement = new TransactionManagement();
        CustomerManagement customerManagement = new CustomerManagement();
        AccountManagement accountManagement = new AccountManagement();
        BankManagement bankManagement = new BankManagement();
        Connection connection = new DatabaseConnection().getConnection();
        Bank bank = new Bank(customerManagement.getAllCustomer(connection), accountManagement.getAllAccounts(connection), transactionManagement.getAllTransaction(connection));
        Connection connection1 = new DatabaseConnection().getConnection();
        System.out.println(connection1 + " " + connection);
//        int sc;
//        do {
//            System.out.println("1. get All");
//            System.out.println("2. add Account");
//            System.out.println("3. execute Transaction");
//            System.out.println("4. withdraw Account");
//            System.out.println("5. deposit Account");
//            System.out.println("0. exit");
//            sc = new Scanner(System.in).nextInt();
//
//            switch (sc) {
//                case 1:
//                    display(bank);
//                    break;
//                case 2:
//                    bankManagement.addAccount(connection, account);
//                    break;
//                case 3:
//                    execute(bankManagement, account, transactionManagement, transaction, connection);
//                    break;
//                case 4:
//                    withdraw(bankManagement, account, accountManagement, connection);
//                    break;
//                case 5:
//                    deposit(bankManagement, account, accountManagement, connection);
//                    break;
//                default:
//                    System.out.println("Invalid option");
//                    break;
//            }
//        } while (sc != 0);
    }

    public static void execute(BankManagement bankManagement, Account account, TransactionManagement transactionManagement, Transaction transaction, Connection connection) throws SQLException {
        System.out.println("Enter id sender: ");
        int senderID = new Scanner(System.in).nextInt();
        System.out.println("Enter id reciever: ");
        int recieverID = new Scanner(System.in).nextInt();
        System.out.println("Enter amount you want to transfer: ");
        double amount = new Scanner(System.in).nextDouble();
        System.out.println("Enter message you want to transfer: ");
        String message = new Scanner(System.in).nextLine();
        bankManagement.executeTransaction(transactionManagement, transaction, senderID, recieverID, amount, message, connection);
    }

    public static void withdraw(BankManagement bankManagement, Account account, AccountManagement accountManagement, Connection connection) throws SQLException {
        System.out.println("Enter id Withdraw: ");
        int senderID = new Scanner(System.in).nextInt();
        double amount = new Scanner(System.in).nextDouble();
        bankManagement.withdrawBank(accountManagement, senderID, amount, connection);
    }

    public static void deposit(BankManagement bankManagement, Account account, AccountManagement accountManagement, Connection connection) throws SQLException {
        System.out.println("Enter id Deposit: ");
        int senderID = new Scanner(System.in).nextInt();
        double amount = new Scanner(System.in).nextDouble();
        bankManagement.depositBank(accountManagement, senderID, amount, connection);
    }

    public static void display(Bank bank) {
        System.out.println("Customer");
        for (int i = 0; i < bank.getCustomers().size(); i++) {
            System.out.println(bank.getCustomers().get(i).toString());
        }
        System.out.println("Account");
        for (int i = 0; i < bank.getAccounts().size(); i++) {
            System.out.println(bank.getAccounts().get(i).toString());
        }
        System.out.println("Transaction");
        for (int i = 0; i < bank.getTransactions().size(); i++) {
            System.out.println(bank.getTransactions().get(i).toString());
        }
    }
}