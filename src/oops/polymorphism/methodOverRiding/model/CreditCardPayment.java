package oops.polymorphism.methodOverRiding.model;

public class CreditCardPayment extends Payment {
    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        double fee = amount * 0.02;
        double total = amount + fee;

        System.out.println("\nProcessing Credit Card Payment...");
        System.out.println("Original Amount: ₹" + amount);
        System.out.println("Processing Fee (2%): ₹" + fee);
        System.out.println("Total Amount Charged: ₹" + total);
        generateReceipt(total);
    }

    public void generateReceipt(double total) {
        System.out.println("Receipt Generated for amount: ₹" + total);
    }

}
