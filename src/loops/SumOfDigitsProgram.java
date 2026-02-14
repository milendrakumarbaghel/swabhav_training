package loops;
import java.util.Scanner;

public class SumOfDigitsProgram {
    public static int findSumOfDigits(int num) {
        int sum = 0;
        num = Math.abs(num);

        while (num != 0) {
            int digit = num % 10;
            sum += digit;
            num = num / 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        int result = findSumOfDigits(num);

        System.out.println("Sum of digits = " + result);

        scanner.close();
    }
}