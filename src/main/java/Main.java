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
        for(int i = 0; i < bank.getCustomers().size(); i++) {
            System.out.println(bank.getCustomers().get(i).toString());
        }

        Bank bank1 = new Bank(null, null, transactionManagement.getAllTransaction(connection));
        for(int i = 0; i < bank1.getTransactions().size(); i++) {
            System.out.println(bank1.getTransactions().get(i).toString());
        }
        //display list of customer, accounts, transactions,
        //add account1 to bank
        //add account2 to bank
        //withdraw money of account1
        //deposit money of account2
        //execute transaction of account 1 to account 2
        //update name
        //update account number

    }
}