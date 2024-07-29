public class CurrentAccount extends Account {
    private double overdraftLimit = 50000;

    public CurrentAccount(String accountID, double balance, String accountHolder) {
        super(accountID, balance, accountHolder);
    }

    @Override
    public void withdraw(double amount) {
        setBalance(getBalance()-amount);
        if (getBalance() < overdraftLimit) {
            System.out.println("Minimum balance of " + overdraftLimit + " required ");
        } else {
            super.withdraw(amount);
        }
    }

}