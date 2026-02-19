package oops.constructor.model;

public class BankAccount {
    private final String accountNumber;
    private String accountHolderName;
    private double balance;
    private static double interestRate;

    static {
        interestRate = 4.5;
    }

    public BankAccount(String accountNumber, String accountHolderName) {
        this(accountNumber, accountHolderName, 0.0);
    }

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null");
        }

        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit must be positive");
            return;
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || balance - amount < 0) {
            System.out.println("Invalid withdrawal");
            return;
        }

        balance -= amount;
    }

    public static double getInterestRate() {
        return interestRate;
    }
}