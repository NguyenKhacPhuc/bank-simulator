package data;

public class Account {
    private int accountID;
    private double balance;
    private String userName;
    private String accNumber;
    private double limitDayWithdrawal;
    private String password;
    private int bankID;

    public Account(int accountID, String userName, double balance, String accNumber, double limitDayWithdrawal, String password, int bankID) {
        this.accountID = accountID;
        this.userName = userName;
        this.balance = balance;
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

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", balance=" + balance +
                ", userName='" + userName + '\'' +
                ", accNumber='" + accNumber + '\'' +
                ", limitDayWithdrawal=" + limitDayWithdrawal +
                ", password='" + password + '\'' +
                ", bankID=" + bankID +
                '}';
    }
}