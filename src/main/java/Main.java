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
        Account account1 = new Account();
        Account account2 = new Account();

        TransactionManagement transactionManagement = new TransactionManagement();
        CustomerManagement customerManagement = new CustomerManagement();
        AccountManagement accountManagement = new AccountManagement();
        BankManagement bankManagement = new BankManagement();
        Connection connection = new DatabaseConnection().getConnection();
        //load all customer, account, transactions to bank
        Bank bank = new Bank(customerManagement.getAllCustomer(connection), null, null);
        //display list of customer, accounts, transactions,
        //add account1 to bank
        //add account2 to bank
        //withdraw money of account1
        //deposit money of account2
        //execute transaction of account 1 to account 2
        Account sender = new Account(1, 10000000.0, "Anh", "123123", 1000000.0, "123", 2);
        Account receiver = new Account(2, 0.0, "Quan", "456456", 1000000.0, "123", 2);
        double amount = 200.0;

        bankManagement.executeTransaction(transactionManagement, transaction, sender, receiver, amount, connection);
        System.out.println(receiver.getBalance());

        //update name
        //update account number
    }
}