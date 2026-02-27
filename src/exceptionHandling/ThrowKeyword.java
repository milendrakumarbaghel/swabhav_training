package exceptionHandling;

public class ThrowKeyword {
    public static void main(String[] args) {

//        int age = 16;
//
//        if (age < 18) {
//            throw new ArithmeticException("Not eligible to vote");
//        }
//
//        System.out.println("Eligible to vote");

//        withdraw(1000,  500);
    }

    static void withdraw(double amount, double balance) {

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient Balance");
        }

        System.out.println("Withdrawal Successful");
    }
}
