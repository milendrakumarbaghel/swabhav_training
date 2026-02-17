package assignments;

import java.util.ArrayList;
import java.util.Scanner;

public class FraudTransactionDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of transactions: ");
        int n = scanner.nextInt();

        while (n<=0) {
            System.out.println("Enter valid number of transactions: ");
            n = scanner.nextInt();
        }

        double[] transactions = new double[n];

//        double[] transactions = {
//                25000, 60000, 70000, 15000, 52000,
//                30000, 80000, 10000, 45000, 90000
//        };

        System.out.println("Enter transaction amounts:");
        for (int i = 0; i < n; i++) {
            transactions[i] = scanner.nextDouble();
        }

        // 1
        ArrayList<Integer> suspiciousIndices = flagSuspiciousTransactions(transactions);

        // 2
        boolean fraudDetected = detectFraudPattern(transactions);

        // 3
        System.out.println("\nSuspicious Transaction Indices: " + suspiciousIndices);

        // 4
        double average = calculateAverage(transactions);
        System.out.println("Average Transaction Value: " + average);

        if (average > 40000) {
            System.out.println("High Value Account");
        }

        if (fraudDetected) {
            System.out.println("Potential Fraud Detected!");
        } else {
            System.out.println("No Fraud Pattern Found");
        }

        scanner.close();
    }

    public static ArrayList<Integer> flagSuspiciousTransactions(double[] transactions) {
        ArrayList<Integer> suspiciousIndices = new ArrayList<>();

        System.out.println("\nSuspicious Transactions:");
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] > 50000) {
                System.out.println("Index " + i + " → ₹" + transactions[i] + " (Suspicious)");
                suspiciousIndices.add(i);
            }
        }

        return suspiciousIndices;
    }

    public static boolean detectFraudPattern(double[] transactions) {
        for (int i = 0; i < transactions.length - 1; i++) {
            if (transactions[i] > 50000 && transactions[i + 1] > 50000) {
                return true;
            }
        }

        return false;
    }

    public static double calculateAverage(double[] transactions) {
        double sum = 0;

        for (double t : transactions) {
            sum += t;
        }

        return sum / transactions.length;
    }
}