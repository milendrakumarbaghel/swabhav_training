package arrays;

import java.util.Scanner;

public class SecondMaximumOfArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of Array: ");
        int size = scanner.nextInt();

        while (size <= 1) {
            System.out.print("Please enter positive/valid size (size is greater than 1): ");
            size = scanner.nextInt();
        }

        int[] arr = new int[size];

        System.out.println("Enter elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }

        System.out.println("Second Maximum: " + secondMax);
    }
}