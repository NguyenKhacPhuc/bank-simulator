

import java.util.ArrayList;
import java.util.List;
public class Bank {
    private List<Customer> customers;
    private List<Account> accounts;
    private List<Transaction> transactions;
    
    public Bank() {
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
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
    
    public Customer getCustomerDetails(String customerId) {
        for(Customer customer : customers) {
            if(customer.getCustomerID().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
    
    public Account getAccountDetails(int accountId) {
        for(Account account : accounts) {
            if(account. getAccountID()== accountId) {
                return account;
            }
        }
        return null;
    }
}



