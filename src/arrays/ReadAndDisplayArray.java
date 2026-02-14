package arrays;

import java.util.Scanner;

public class ReadAndDisplayArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of array: ");
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

        System.out.println("Array elements are:");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}