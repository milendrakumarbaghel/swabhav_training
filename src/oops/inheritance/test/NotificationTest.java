package oops.inheritance.test;

import oops.inheritance.model.EmailNotification;
import oops.inheritance.model.Notification;
import oops.inheritance.model.PushNotification;
import oops.inheritance.model.SMSNotification;

import java.util.Scanner;

public class NotificationTest {
    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Email Notification");
            System.out.println("2. SMS Notification");
            System.out.println("3. Push Notification");
            System.out.println("4. Exit");
            System.out.print("Choose type: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter numeric value: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();



            if (choice >= 1 && choice <= 3) {
                System.out.print("Enter Recipient: ");
                String recipient = scanner.nextLine();

                while (!isValidText(recipient)) {
                    System.out.print("Invalid recipient. Enter again: ");
                    recipient = scanner.nextLine();
                }

                System.out.print("Enter Message: ");
                String message = scanner.nextLine();

                while (!isValidText(message)) {
                    System.out.print("Invalid message. Enter again: ");
                    message = scanner.nextLine();
                }

                Notification notification = switch (choice) {
                    case 1 -> new EmailNotification(recipient, message);
                    case 2 -> new SMSNotification(recipient, message);
                    case 3 -> new PushNotification(recipient, message);
                    default -> null;
                };

                notification.send();

            } else if (choice == 4) {
                System.out.println("Exit");
            } else {
                System.out.println("Invalid choice");
            }

        } while (choice != 4);

        scanner.close();
    }

    public static boolean isValidText(String text) {
        return text != null && !text.trim().isEmpty();
    }
}
