public class Customer {
    private String customerID;
    private String Name;
    private String Address;
    private String Phone;
    private String accountsID;

    public Customer(String customerID, String name, String address, String phone, String accountsID) {
        this.customerID = customerID;
        Name = name;
        Address = address;
        Phone = phone;
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

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAccountsID() {
        return accountsID;
    }

    public void setAccountsID(String accountsID) {
        this.accountsID = accountsID;
    }
}
