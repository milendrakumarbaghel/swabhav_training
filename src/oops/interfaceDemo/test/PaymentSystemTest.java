package oops.interfaceDemo.test;

import oops.interfaceDemo.model.CreditCardPayment;
import oops.interfaceDemo.model.DebitCardPayment;
import oops.interfaceDemo.model.Payment;
import oops.interfaceDemo.model.UPIPayment;

import java.util.Scanner;

public class PaymentSystemTest {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of payments: ");
        int total = readPositiveInt(scanner);

        Payment[] payments = new Payment[total];
        double[] amounts = new double[total];

        for (int i = 0; i < total; i++) {
            System.out.println("\nPayment No " + (i + 1));
            System.out.println("1. Credit Card");
            System.out.println("2. Debit Card");
            System.out.println("3. UPI");
            System.out.print("Choose payment type: ");

            int type = readValidPaymentType(scanner);

            scanner.nextLine();

            System.out.print("Enter Amount: ");
            double amount = readPositiveDouble(scanner);
            amounts[i] = amount;

            scanner.nextLine();

            switch (type) {
                case 1:
                    System.out.print("Enter Credit Card Number (5 digits): ");
                    String creditCard = readValidCardNumber(scanner);
                    payments[i] = new CreditCardPayment(creditCard);
                    break;

                case 2:
                    System.out.print("Enter Debit Card Number (5 digits): ");
                    String debitCard = readValidCardNumber(scanner);
                    payments[i] = new DebitCardPayment(debitCard);
                    break;

                case 3:
                    System.out.print("Enter UPI ID: ");
                    String upiId = readValidUpi(scanner);
                    payments[i] = new UPIPayment(upiId);
                    break;
            }
        }

        System.out.println("\nPROCESSING PAYMENTS\n");

        for (int i = 0; i < payments.length; i++) {
            payments[i].processPayment(amounts[i]);
        }

        scanner.close();
    }

    public static int readPositiveInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter numeric value: ");
            scanner.next();
        }

        int value = scanner.nextInt();

        while (value <= 0) {
            System.out.print("Value must be greater than 0. Enter again: ");
            value = readPositiveInt(scanner);
        }

        return value;
    }

    public static double readPositiveDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Enter numeric value: ");
            scanner.next();
        }

        double value = scanner.nextDouble();

        while (value <= 0) {
            System.out.print("Amount must be greater than 0. Enter again: ");
            value = readPositiveDouble(scanner);
        }

        return value;
    }

    public static int readValidPaymentType(Scanner scanner) {
        int type = readPositiveInt(scanner);

        while (type != 1 && type != 2 && type != 3) {
            System.out.print("Invalid choice. Enter again (1-3): ");
            type = readPositiveInt(scanner);
        }

        return type;
    }

    public static String readValidCardNumber(Scanner scanner) {
        String card = scanner.nextLine().trim();

        while (!card.matches("\\d{5}")) {
            System.out.print("Invalid card number. Enter 5 digit number {eg. 12345}: ");
            card = scanner.nextLine().trim();
        }

        return card;
    }

    public static String readValidUpi(Scanner scanner) {
        String upi = scanner.nextLine().trim();

        while (!upi.matches("^[a-zA-Z0-9._-]+@[a-zA-Z]+$")) {
            System.out.print("Invalid UPI ID. Enter again (example: name@bank): ");
            upi = scanner.nextLine().trim();
        }

        return upi;
    }
}
