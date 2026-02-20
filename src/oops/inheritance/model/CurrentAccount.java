package oops.inheritance.model;

import oops.inheritance.model.Account;

public class CurrentAccount extends Account {
    private final double overDraftLimit;

    public CurrentAccount(String accountHolderName, double balance, double overDraftLimit) {
        super(accountHolderName, balance);

        this.overDraftLimit = overDraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if(amount<=0) {
            System.out.println("Withdraw amount should be greater than zero");
            return;
        }

        double currentBalance = super.getBalance();

        if(Math.abs(currentBalance-amount) > overDraftLimit) {
            System.out.println("Can't withdraw, overdraft limit exceeded\n Overdraft Limit: "  + overDraftLimit);
            return;
        }

        balance -= amount;
//        super.withdraw(amount);
        System.out.println("withdraw successful");
    }
}
