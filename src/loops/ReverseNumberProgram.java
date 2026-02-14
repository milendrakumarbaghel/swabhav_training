package loops;
import java.util.Scanner;

public class ReverseNumberProgram {
    public static int reverseNumber(int num) {
        int reverse = 0;

        while (num != 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num = num / 10;
        }

        return reverse;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        int reversed = reverseNumber(num);

        System.out.println("Reversed number = " + reversed);

        scanner.close();
    }
}