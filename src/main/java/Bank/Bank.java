package Bank;

import java.util.List;

public class Bank {
    private List<Customer> customers;
    private List<Account> accounts;

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(String accountId) {
        accounts.removeIf(account -> account.getAccountId().equals(accountId));
    }

    public void executeTransaction(Transaction transaction) {
        // Transaction logic
    }

    public Customer getCustomerDetails(String customerId) {
        return customers.stream().filter(c -> c.getCustomerId().equals(customerId)).findFirst().orElse(null);
    }

    public Account getAccountDetails(String accountId) {
        return accounts.stream().filter(a -> a.getAccountId().equals(accountId)).findFirst().orElse(null);
    }
    
    // Additional Methods
}


