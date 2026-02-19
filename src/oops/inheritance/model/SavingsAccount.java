package oops.inheritance.model;

public class SavingsAccount extends Account {
    private final double minimumBalance;

    public SavingsAccount(String accountHolderName, double balance, double minimumBalance) {
        super(accountHolderName, balance);

        this.minimumBalance = minimumBalance;
    }

    @Override
    public void withdraw(double amount) {
        if(amount<=0) {
            System.out.println("Withdraw amount should be greater than zero");
        }

        double currentBalance = super.getBalance();

        if(currentBalance-amount < minimumBalance) {
            System.out.println("Can't withdraw, minimum balance should be maintained: "  + minimumBalance);
            return;
        }

        super.withdraw(amount);
        System.out.println("withdraw Successful");
    }
}
