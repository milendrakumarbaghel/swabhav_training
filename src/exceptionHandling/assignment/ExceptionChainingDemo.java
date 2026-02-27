package exceptionHandling.assignment;

public class ExceptionChainingDemo {
    static void main(String[] args) {
        try {
            processPayment();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

    public static void processPayment() {
        try {
            String string = null;
            string.length();
        } catch (NullPointerException e) {
            throw new RuntimeException("Payment failed", e);
        }
    }
}
