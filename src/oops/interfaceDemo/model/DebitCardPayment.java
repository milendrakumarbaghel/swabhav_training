package oops.interfaceDemo.model;

public class DebitCardPayment implements Payment {
    private String cardNumber;

    public DebitCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
        System.out.println("DebitCardPayment object created.");
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Debit Card Payment...");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Amount Paid: ₹" + amount);
        System.out.println("Payment Successful via Debit Card.\n");
    }
}
