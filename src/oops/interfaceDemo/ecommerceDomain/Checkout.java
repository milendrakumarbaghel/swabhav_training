package oops.interfaceDemo.ecommerceDomain;

public class Checkout {
    private PaymentGateway paymentGateway;

    public Checkout(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void makePayment(double amount) {
        paymentGateway.pay(amount);
    }

    public void processRefund(double amount) {
        paymentGateway.refund(amount);
    }
}
