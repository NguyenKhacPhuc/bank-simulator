import controller.AccountManagement;
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

public class Main {
    //Load data everytime app start: Đức Anh
    public static void main(String[] args) throws SQLException {
        //khởi tạo
        Transaction transactionDB = new Transaction();
        Customer customerDB = new Customer();
        Account accountDB = new Account();

        TransactionManagement transactionManagement = new TransactionManagement();
        CustomerManagement customerManagement = new CustomerManagement();
        AccountManagement accountManagement = new AccountManagement();

        Connection connection = new DatabaseConnection().getConnection();
        Bank bank = new Bank(customerManagement.getAllCustomer(connection), null, null);
        System.out.println("Enter your choice");
        System.out.println("1. Delete data.Transaction");
        System.out.println("2. Delete data.Customer");
        System.out.println("3. Delete data.Account");
        switch (new Scanner(System.in).nextInt()) {
            case 1:
                transactionManagement.deleteTransaction(connection, transactionDB);
                break;
            case 2:
                customerManagement.deleteCustomer(connection, customerDB);
                break;
            case 3:
                accountManagement.deleteAccount(connection, accountDB);
                break;
            default: break;
        }
    }
}