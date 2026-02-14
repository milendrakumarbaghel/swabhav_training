package arrays;

import java.util.Scanner;

public class PeakElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int size = sc.nextInt();

        while (size <= 0) {
            System.out.print("Please enter positive size: ");
            size = sc.nextInt();
        }

        int[] arr = new int[size];

        System.out.println("Enter elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Peak elements:");

        for (int i = 0; i < size; i++) {
            if ((i == 0 || arr[i] > arr[i - 1]) &&
                    (i == size - 1 || arr[i] > arr[i + 1])) {
                System.out.println(arr[i]);
            }
        }
    }
}
