package arrays;
import java.util.Scanner;

public class MatrixOperations {

    // Function to input matrix
    public static void inputMatrix(int[][] matrix, Scanner sc) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    // Function to display matrix
    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Function for addition
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    // Function for multiplication
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = B[0].length;
        int n = A[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    // Function for transpose
    public static int[][] transposeMatrix(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = A[i][j];
            }
        }
        return transpose;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int r = scanner.nextInt();

        System.out.print("Enter columns: ");
        int c = scanner.nextInt();

        int[][] A = new int[r][c];
        int[][] B = new int[r][c];

        System.out.println("Enter Matrix A:");
        inputMatrix(A, scanner);

        System.out.println("Enter Matrix B:");
        inputMatrix(B, scanner);

        System.out.println("1. Addition");
        System.out.println("2. Multiplication");
        System.out.println("3. Transpose of A");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                int[][] sum = addMatrices(A, B);
                System.out.println("Addition Result:");
                displayMatrix(sum);
                break;

            case 2:
                int[][] product = multiplyMatrices(A, B);
                System.out.println("Multiplication Result:");
                displayMatrix(product);
                break;

            case 3:
                int[][] transpose = transposeMatrix(A);
                System.out.println("Transpose of Matrix A:");
                displayMatrix(transpose);
                break;

            default:
                System.out.println("Invalid choice");
        }
    }
}