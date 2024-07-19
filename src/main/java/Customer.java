public class Customer {
    private String customerID;
    private String Name;
    private String Address;
    private String accountsID;

    public Customer(String customerID, String name, String address, String accountsID) {
        this.customerID = customerID;
        Name = name;
        Address = address;
        this.accountsID = accountsID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAccountsID() {
        return accountsID;
    }

    public void setAccountsID(String accountsID) {
        this.accountsID = accountsID;
    }
}
