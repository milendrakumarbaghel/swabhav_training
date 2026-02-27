package exceptionHandling.assignment;

public class InvalidPassswordException extends Exception {
    public InvalidPassswordException(String message) {
        super(message);
    }
}
