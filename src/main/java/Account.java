public class Account {
    private String accountID;
    private double balance;
    private String accountHolder;

    public Account(String accountID, double balance, String accountHolder) {
        this.balance = balance;
        this.accountHolder = accountHolder;
        this.accountID = accountID;
    }

    public void withdraw(double amount) {
        if (balance > amount) {
            balance = balance - amount;
            System.out.println("Your balance is " + balance);
        } else
            System.out.println("Insufficient balance");
    }

    public void deposit(double amount) {
        if (amount > 0)
            balance = balance + amount;
        System.out.println("Your balance is " + balance);
    }

    public void transfer(double amount) {
        if (balance > amount)
            balance = balance - amount;
        System.out.println("Transfer success!");
        System.out.println("Your balance is " + balance);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}




