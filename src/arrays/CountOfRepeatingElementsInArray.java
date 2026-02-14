package arrays;
import java.util.Scanner;

public class CountOfRepeatingElementsInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of Array: ");
        int size = scanner.nextInt();

        while (size <= 0) {
            System.out.print("Please enter positive/valid size: ");
            size = scanner.nextInt();
        }

        int[] arr = new int[size];

//        int[] arr = {1, 2, 3, 4, 3, 7, 7, 4, 4, 5, 6, 7};
//        int size = arr.length;

        System.out.println("Enter elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter number to count: ");
        int num = scanner.nextInt();

        int count = 0;

        for (int i = 0; i < size; i++) {
            if (arr[i] == num) {
                count++;
            }
        }

        System.out.println("Number " +num+ " repeated "+count+ " times.");
        scanner.close();
    }
}