public class Main {
    public static void main(String[] args) {
        System.out.println("Create a Bank Account object");
        Account Alex = new Account("1234", 1000000, "Alex");
        System.out.println("Deposit 2.000.000 into account Alex:");
        Alex.deposit(2000000);
        System.out.println("Transfer 100.000 from account Alex:");
        Alex.transfer(100000);
        //System.out.println("Withdraw 3.000.000 from account Alex:");
        //Alex.withdraw(3000000);
        CurrentAccount Andy = new CurrentAccount("131", 1000000, "Andy");
        Andy.withdraw(970000);
        SavingAccount Rose = new SavingAccount("191", 1000000, "Rose");
        Rose.calculateInterest(6);
    }
}
