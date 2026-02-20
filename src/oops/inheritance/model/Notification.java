package oops.inheritance.model;

public class Notification {
    protected String recipient;
    protected String message;

    public Notification(String recipient, String message) {

        if (recipient.isBlank() || recipient.trim().isEmpty()) {
            System.out.println("Invalid recipient. Setting default.");
            return;
        }
        this.recipient = recipient;


        if (message.isBlank() || message.trim().isEmpty()) {
            System.out.println("Invalid message. Setting default.");
            return;
        }
        this.message = message;
    }

    public void logNotification() {
        System.out.println("LOG -> Notification prepared for: " + recipient);
    }

    public void send() {
        System.out.println("Sending notification");
    }
}
