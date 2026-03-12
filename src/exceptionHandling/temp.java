package exceptionHandling;

public class temp {
    static void main() {
        try{
            throw new ArithmeticException("exception");
        } finally{
            System.out.println("finally block");
        }
    }
}
