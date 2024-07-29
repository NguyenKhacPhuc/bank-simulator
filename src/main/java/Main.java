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
        //load all customer, account, transactions to bank
//        Bank bank = new Bank(customerManagement.getAllCustomer(connection), null, null);
//        for(int i = 0; i < bank.getCustomers().size(); i++) {
//            System.out.println(bank.getCustomers().get(i).toString());
//        }
//
//        Bank bank1 = new Bank(null, null, transactionManagement.getAllTransaction(connection));
//        for(int i = 0; i < bank1.getTransactions().size(); i++) {
//            System.out.println(bank1.getTransactions().get(i).toString());
//        }
//
//        Bank bank2 = new Bank(null, accountManagement.getAllAccounts(connection), null);
//        for(int i = 0; i < bank2.getAccounts().size(); i++) {
//            System.out.println(bank2.getAccounts().get(i).toString());
//        }

//        Account account3 = new Account(8, "Truong The Vinh", 2000, "123478910", 100000, "1", 1);
//        Account account4 = new Account(9, "Bao Phuc", 2000, "123478912", 100000, "1", 1);
//        double am = 200;
//        bankManagement.executeTransaction(transactionManagement, transaction, account3, account4, am, connection);
//        transactionManagement.getAccountBalance(account3.getAccountID(), connection);


        //display list of customer, accounts, transactions,
        Bank bank = new Bank(customerManagement.getAllCustomer(connection), accountManagement.getAllAccounts(connection), transactionManagement.getAllTransaction(connection));
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
        //add account1 to bank
        //bankManagement.addAccount(connection, account);
        //add account2 to bank
        //bankManagement.addAccount(connection, account);
        //withdraw money of account1
        //deposit money of account2
        //execute transaction of account 1 to account 2
//
        execute(bankManagement, account, transactionManagement, transaction, connection);
        //update name
        //update account number


        //Tao ham va dung switch case
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
}