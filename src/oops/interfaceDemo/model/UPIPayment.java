package oops.interfaceDemo.model;

public class UPIPayment implements Payment{
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
        System.out.println("UPIPayment object created.");
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI Payment...");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Amount Paid: ₹" + amount);
        System.out.println("Payment Successful via UPI.\n");
    }
}
