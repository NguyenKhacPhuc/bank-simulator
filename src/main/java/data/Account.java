package data;

public class Account {
    private int accountID;
    private double balance;
    private String userName;
    private String accNumber;
    private double limitDayWithdrawal;
    private String password;
    private int bankID;

    public Account(int accountID, double balance, String userName, String accNumber, double limitDayWithdrawal, String password, int bankID) {
        this.accountID = accountID;
        this.balance = balance;
        this.userName = userName;
        this.accNumber = accNumber;
        this.limitDayWithdrawal = limitDayWithdrawal;
        this.password = password;
        this.bankID = bankID;
    }

    public Account() {
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public double getLimitDayWithdrawal() {
        return limitDayWithdrawal;
    }

    public void setLimitDayWithdrawal(double limitDayWithdrawal) {
        this.limitDayWithdrawal = limitDayWithdrawal;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            this.balance += amount;
        }
        System.out.println("Your balance is " + balance);
    }

    public void withdraw(double amount) {
        if(balance > amount ){
            this.balance -= amount;
            System.out.println("Your balance is " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void transfer(double amount) {
        if(balance > amount) {
            this.balance -= amount;
        }
        System.out.println("Transfer successful");
        System.out.println("Your balance is " + balance);
    }
}