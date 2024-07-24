package Bank;

public class Main {
    public static void main(String[] args) {
        Bank myBank = new Bank();
        Customer customer1 = new Customer("1", "vinh", "nghe an", "0123456", "1");
        myBank.addCustomer(customer1);
        Account myAccount = new Account(1, 2300, "vinh ne", "acc123456", 10000, "nopass", 1);
        myBank.addAccount(myAccount);
        Customer getCustomer = myBank.getCustomerDetails("1");

        System.out.println("Customer id: " + getCustomer.getCustomerID());
        System.out.println("Customer name: " + getCustomer.getName());
         
        Account getAccount = myBank.getAccountDetails(1);

        System.out.println("Account id : " + getAccount.getAccountID());
        System.out.println("Account name: " + getAccount.getUserName());
    }
}
