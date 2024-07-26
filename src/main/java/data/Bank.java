package data;

import java.util.List;

public class Bank {
    private List<Customer> customers;
    private List<Account> accounts;
    private List<Transaction> transactions;


    public Bank(List<Customer> customers, List<Account> accounts, List<Transaction> transactions) {
        this.customers = customers;
        this.accounts = accounts;
        this.transactions = transactions;
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