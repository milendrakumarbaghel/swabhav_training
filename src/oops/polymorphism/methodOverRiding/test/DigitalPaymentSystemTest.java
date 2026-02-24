package oops.polymorphism.methodOverRiding.test;

import oops.polymorphism.methodOverRiding.model.CreditCardPayment;
import oops.polymorphism.methodOverRiding.model.Payment;
import oops.polymorphism.methodOverRiding.model.UPIPayment;
import oops.polymorphism.methodOverRiding.model.WalletPayment;

import java.util.Scanner;

public class DigitalPaymentSystemTest {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of payments done: ");
        int totalPayments = readValidInt(scanner);

        while (totalPayments <= 0) {
            System.out.print("Invalid number of payments. Enter again: ");
            totalPayments = readValidInt(scanner);
        }

        Payment[] payments = new Payment[totalPayments];

        for (int i = 0; i < totalPayments; i++) {
            System.out.println("\nPayment no " + (i + 1));
            System.out.println("1. Credit Card Payment (2% processing fees)");
            System.out.println("2. UPI Payment (0% processing fees)");
            System.out.println("3. WALLET Payment (1% processing fees)");
            System.out.print("Choose type of Payment: ");

            int type = readValidInt(scanner);

            while (!isValidPaymentType(type)) {
                System.out.print("Invalid type. Enter again (1-3): ");
                type = readValidInt(scanner);
            }

            scanner.nextLine();
            double amount = amountInput(scanner);
            scanner.nextLine();

            switch (type) {
                case 1:
                    payments[i] = new CreditCardPayment(amount);
                    break;

                case 2:
                    payments[i] = new UPIPayment(amount);
                    break;

                case 3:
                    payments[i] = new WalletPayment(amount);
                    break;
            }
        }

        System.out.println("\nPayments Receipts:  ");

        for (Payment payment : payments) {
            payment.processPayment();

        }
        scanner.close();
    }

    public static int readValidInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter numeric value: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static double readValidDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Enter numeric value: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static boolean isValidPaymentType(int type) {
        return type == 1 || type == 2 || type == 3;
    }

    public static boolean isValidName(String name) {
        if (name == null) return false;
        name = name.trim();
        if (name.isEmpty()) return false;
        return name.matches("[a-zA-Z ]+");
    }

    public static double amountInput(Scanner scanner) {
        System.out.print("Enter amount: ");
        double amount = readValidDouble(scanner);
        while (amount <= 0) {
            System.out.print("amount must be > 0. Enter amount again: ");
            amount = readValidDouble(scanner);
        }

        return amount;
    }
}
