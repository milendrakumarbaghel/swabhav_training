package arrays;

import java.util.Scanner;

public class SumOfArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of Array: ");
        int size = scanner.nextInt();

        while (size <= 0) {
            System.out.print("Please enter positive/valid size: ");
            size = scanner.nextInt();
        }

        int[] arr = new int[size];
        int sum = 0;

        System.out.println("Enter elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }

        System.out.println("Sum of elements: " + sum);

        scanner.close();
    }
}