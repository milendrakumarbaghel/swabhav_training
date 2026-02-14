package arrays;
import java.util.Scanner;

public class FindMaximum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of Array: ");
        int size = scanner.nextInt();

        while (size <= 0) {
            System.out.print("Please enter positive/valid size: ");
            size = scanner.nextInt();
        }

        int[] arr = new int[size];

        System.out.println("Enter elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = arr[0];

        for (int i = 1; i < size; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Maximum element in array is: " + max);

        scanner.close();
    }
}