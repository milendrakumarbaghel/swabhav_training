package oops.encapsulation.model;

import java.util.UUID;

public class BankAccount {
    private final String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, double firstDeposit) {
        this.accountNumber = UUID.randomUUID().toString();

        if(accountHolderName.isBlank()) {
            System.out.println("Name should not be empty");
            return;
        }
        this.accountHolderName = accountHolderName;

        if(firstDeposit < 0) {
            System.out.println("Minimum deposit should be greater than equals to zero");
        }
        this.balance = firstDeposit;

    }

    public double getBalance()  {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive");
            return;
        }

        balance += amount;
        System.out.println("Amount deposited successfully");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance");
            return;
        }

        balance -= amount;
        System.out.println("Amount withdraw successfully");
    }
}
