package loops;
import java.util.Scanner;

public class ArmstrongNumberProgram {
    public static boolean isArmstrong(int num) {
        int original = num;
        int sum = 0;
        int digits = 0;

        int temp = num;
        while (temp != 0) {
            digits++;
            temp = temp / 10;
        }

        temp = num;

        while (temp != 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp = temp / 10;
        }

        return sum == original;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        if (isArmstrong(num))
            System.out.println(num + " is an Armstrong number.");
        else
            System.out.println(num + " is NOT an Armstrong number.");

        scanner.close();
    }
}