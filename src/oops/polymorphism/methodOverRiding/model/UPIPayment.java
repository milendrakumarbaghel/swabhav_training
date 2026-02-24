package oops.polymorphism.methodOverRiding.model;

public class UPIPayment extends Payment {
    public UPIPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        System.out.println("\nProcessing UPI Payment...");
        System.out.println("Amount Debited: ₹" + amount);
        generateReceipt();
    }
}
