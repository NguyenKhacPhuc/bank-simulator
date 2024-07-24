package data;

public class Customer {
    private int customerID;
    private String Name;
    private String Address;
    private String accountsID;

    public Customer(int customerID, String name, String address, String accountsID) {
        this.customerID = customerID;
        Name = name;
        Address = address;
        this.accountsID = accountsID;
    }

    public Customer() {

    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
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

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", accountsID='" + accountsID + '\'' +
                '}';
    }
}