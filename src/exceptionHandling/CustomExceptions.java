package exceptionHandling;

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

public class CustomExceptions {
    public static void main(String[] args) {
        try {
            withdraw(-96);
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    static void withdraw(int amount) throws InvalidAmountException {

        if (amount < 0) {
            throw new InvalidAmountException("Invalid amount");
        }

        System.out.println("Valid transaction");
    }

}
