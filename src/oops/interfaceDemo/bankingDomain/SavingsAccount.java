package oops.interfaceDemo.bankingDomain;

public class SavingsAccount implements AccountOperations {
    private double balance;
    private final double WITHDRAWAL_LIMIT = 10000;

    public SavingsAccount(double initialBalance) {
        if(initialBalance<0) {
            System.out.println("Invalid initial balance");
            return;
        }
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        if(amount<=0) {
            System.out.println("Invalid amount, amount can't be less than equal to zero");
        }

        balance += amount;
        System.out.println("Amount deposited in Savings Account: ₹" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > WITHDRAWAL_LIMIT) {
            System.out.println("Withdrawal limit exceeded! Limit: ₹" + WITHDRAWAL_LIMIT);
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }

        balance -= amount;
        System.out.println("Amount withdrawn from Savings Account: ₹" + amount);
    }

    @Override
    public void checkBalance() {
        System.out.println("Savings Account Balance: ₹" + balance);
    }
}
