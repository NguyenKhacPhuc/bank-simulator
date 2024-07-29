public class SavingAccount extends Account{
    private double overdraftLimit;

    public SavingAccount(String accountID, double balance, String accountHolder) {
        super(accountID, balance, accountHolder);
    }
    double interest;
    public void calculateInterest(double interestRate) {
        if (interestRate > 0) {
            interest = getBalance() * interestRate / 100;
            setBalance(getBalance() + interest);
        }
        System.out.println("Your balance is " + getBalance());
    }
}

