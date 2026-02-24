package oops.polymorphism.methodOverRiding.model;

public class WalletPayment extends Payment{
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        double fee = amount * 0.01;
        double total = amount + fee;

        System.out.println("\nProcessing Wallet Payment...");
        System.out.println("Original Amount: ₹" + amount);
        System.out.println("Processing Fee (1%): ₹" + fee);
        System.out.println("Total Amount Deducted: ₹" + total);
        generateReceipt(total);
    }

    public void generateReceipt(double total) {
        System.out.println("Receipt Generated for amount: ₹" + total);
    }
}
