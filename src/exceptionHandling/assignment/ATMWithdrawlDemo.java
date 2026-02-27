package exceptionHandling.assignment;

import java.util.Scanner;

public class ATMWithdrawlDemo {
    static int balance = 10000;

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter withdrawal amount: ");
            int amount = scanner.nextInt();

            withdrawl(amount);

        } catch (ArithmeticException e) {
            System.out.println("Transaction failed: " + e.getMessage());

        } finally {
            System.out.println("Transaction session ended.");
            scanner.close();
        }
    }

    public static void withdrawl(int amount) {
        if (amount > balance) {
            throw new ArithmeticException("Insufficient balance");
        }

        balance -= amount;
        System.out.println("Withdrawal successful!");
        System.out.println("Remaining balance: ₹" + balance);
    }
}
