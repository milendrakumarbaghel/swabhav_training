package assignment10_03_26.main;

public abstract class Account {
    private int accountNumber;
    private String holderName;
    private double balance;

    public Account(int accountNumber, String holderName, double balance) {

        if (accountNumber <= 0)
            throw new IllegalArgumentException("Account number must be positive.");

        if (holderName == null || holderName.trim().isEmpty())
            throw new IllegalArgumentException("Holder name cannot be empty.");

        if (balance < 0)
            throw new IllegalArgumentException("Balance cannot be negative.");

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        if (balance < 0)
            throw new IllegalArgumentException("Balance cannot become negative.");
        this.balance = balance;
    }

    public abstract void displayDetails();
}
