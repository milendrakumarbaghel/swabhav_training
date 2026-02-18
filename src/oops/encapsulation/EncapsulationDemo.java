package oops.encapsulation;

import java.util.Scanner;

class BankAccount {
    private double balance;
    private String password;

    public BankAccount(String password, double initialBalance) {
        this.password = password;
        this.balance = initialBalance;
    }

    public void checkBalance(String enteredPassword) {
        if (this.password.equals(enteredPassword)) {
            System.out.println("Your Balance is: " + balance);
        } else {
            System.out.println("Incorrect Password! Access Denied.");
        }
    }

    public void deposit(double amount, String enteredPassword) {
        if (this.password.equals(enteredPassword)) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Amount Deposited Successfully.");
            } else {
                System.out.println("Invalid Amount.");
            }
        } else {
            System.out.println("Incorrect Password! Deposit Failed.");
        }
    }

    public void withdraw(double amount, String enteredPassword) {
        if (this.password.equals(enteredPassword)) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal Successful.");
            } else {
                System.out.println("Insufficient Balance or Invalid Amount.");
            }
        } else {
            System.out.println("Incorrect Password! Withdrawal Failed.");
        }
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount("1234", 10000);

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        account.checkBalance(pass);

        System.out.println("\nTrying to Deposit 2000...");
        account.deposit(2000, pass);

        System.out.println("\nTrying to Withdraw 5000...");
        account.withdraw(5000, pass);

        System.out.println("\nFinal Balance Check:");
        account.checkBalance(pass);

        sc.close();
    }
}