package data;

public class Customer {
    private int customerID;
    private String Name;
    private int Age;
    private String Address;
    private int accountsID;

    public Customer(int customerID, String name, int age, String address, int accountsID) {
        this.customerID = customerID;
        Name = name;
        Age = age;
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

    public int getAccountsID() {
        return accountsID;
    }

    public void setAccountsID(int accountsID) {
        this.accountsID = accountsID;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
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