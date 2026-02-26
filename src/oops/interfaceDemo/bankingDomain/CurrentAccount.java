package oops.interfaceDemo.bankingDomain;

public class CurrentAccount implements AccountOperations {
    private double balance;
    private final double OVERDRAFT_LIMIT = 20000;

    public CurrentAccount(double initialBalance) {
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
        System.out.println("Amount deposited in Current Account: ₹" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < -OVERDRAFT_LIMIT) {
            System.out.println("Overdraft limit exceeded!");
            return;
        }

        balance -= amount;
        System.out.println("Amount withdrawn from Current Account: ₹" + amount);
    }

    @Override
    public void checkBalance() {
        System.out.println("Current Account Balance: ₹" + balance);
    }
}
