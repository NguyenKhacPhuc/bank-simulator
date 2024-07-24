package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bank {
    private List<Customer> customers;
    private List<Account> accounts;
    private List<Transaction> transactions;


    public Bank(List<Customer> customers, List<Account> accounts, List<Transaction> transactions) {
        this.customers = customers;
        this.accounts = accounts;
        this.transactions = transactions;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public void executeTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}