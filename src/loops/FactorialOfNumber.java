package loops;
import java.util.Scanner;

public class FactorialOfNumber {
    public static long findFactorial(int num) {
        if (num < 0) {
            return -1;
        }

        long fact = 1;

        for (int i = 1; i <= num; i++) {
            fact *= i;
        }

        return fact;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        long result = findFactorial(num);

        if (result == -1) {
            System.out.println("Factorial not defined for negative numbers.");
        } else {
            System.out.println("Factorial of " + num + " = " + result);
        }

        scanner.close();
    }
}