package oops.interfaceDemo.model;

public class CreditCardPayment implements Payment {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
        System.out.println("CreditCardPayment object created.");
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card Payment...");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Amount Paid: ₹" + amount);
        System.out.println("Payment Successful via Credit Card.\n");
    }
}
