package oops.inheritance.model;

import java.util.UUID;

public class Account {
    protected final String accountNumber;
    protected String accountHolderName;
    protected double balance;

    public Account( String accountHolderName, double balance) {
        this.accountNumber = UUID.randomUUID().toString();

        if(accountHolderName.isBlank()) {
            System.out.println("Invalid account holder name");
            return;
        }
        this.accountHolderName = accountHolderName;

        if(balance<0) {
            System.out.println("Balance should be greater or equal to zero");
            return;
        }
        this.balance  = balance;

        System.out.println("Account created successfully");
        System.out.println("Account details are: ");
        System.out.println("Account number is: " + accountNumber);
        System.out.println("Account holder name is: " + accountHolderName);
        System.out.println("Account open with balance: " + balance);
    }

    public double getBalance()  {
        return balance;
    }

    public void deposit(double amount) {
        if(amount<=0) {
            System.out.println("Invalid deposit amount, please enter amount greater than zero");
            return;
        }

        balance += amount;
        System.out.println("Deposit successful");
    }

    public void withdraw(double amount) {
        if(amount<=0) {
            System.out.println("Invalid deposit amount, please enter amount greater than zero");
            return;
        }

        if(amount>= balance) {
            System.out.println("Insufficient balance in your account");
            return;
        }

        balance -= amount;
        System.out.println("Withdraw successful");
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}
