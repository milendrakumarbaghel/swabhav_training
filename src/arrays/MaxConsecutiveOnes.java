package arrays;

import java.util.Scanner;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter binary elements (0 or 1):");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < size; i++) {
            if (arr[i] == 1) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }

        System.out.println("Maximum consecutive 1s: " + maxCount);
    }
}
