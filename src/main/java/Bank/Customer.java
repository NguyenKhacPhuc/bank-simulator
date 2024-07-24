package Bank;


import java.util.List;

public class Customer {
    private String customerID;
    private String name;
    private String address;
    private String phone;
    private String accountsID;

    public Customer(String customerID, String name, String address, String phone, String accountsID) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.accountsID = accountsID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountsID() {
        return accountsID;
    }

    public void setAccountsID(String accountsID) {
        this.accountsID = accountsID;
    }
}
