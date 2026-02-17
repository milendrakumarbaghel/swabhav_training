package assignments;

import java.util.Scanner;

public class ElectricityUsagePatternDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 30;
        int[] usage = new int[n];

//        int[] usage = {
//                120, 450, 520, 610, 700, 300, 90, 80, 150, 480, 510, 530, 550, 200, 340, 600, 620, 100, 95, 85, 410,
//                420, 430, 510, 300, 250, 700, 710, 720
//        };

        System.out.println("Enter electricity usage for 30 days:");
        for (int i = 0; i < n; i++) {
            usage[i] = scanner.nextInt();
        }

        // 1
        classifyDailyUsage(usage);

        // 2
        boolean overload = detectOverloadWarning(usage);
        if (overload) {
            System.out.println("\n Overload Warning Detected");
        } else {
            System.out.println("\nNo Overload Warning");
        }

        // 3
        double average = calculateMonthlyAverage(usage);
        System.out.println("Monthly Average Usage: " + average);

        if (average > 400) {
            System.out.println("Heavy Month");
        }

        // 4
        int highDays = countHighConsumptionDays(usage);
        System.out.println("Number of High Consumption Days: " + highDays);

        scanner.close();
    }

    public static void classifyDailyUsage(int[] usage) {
        System.out.println("\nDaily Classification:");

        for (int i = 0; i < usage.length; i++) {
            if (usage[i] > 500) {
                System.out.println("Day " + (i + 1) + ": High Consumption");
            } else if (usage[i] < 100) {
                System.out.println("Day " + (i + 1) + ": Low Usage Alert");
            } else {
                System.out.println("Day " + (i + 1) + ": Normal Usage");
            }
        }
    }

    public static boolean detectOverloadWarning(int[] usage) {
        for (int i = 0; i < usage.length - 2; i++) {
            if (usage[i] > 500 &&
                    usage[i + 1] > 500 &&
                    usage[i + 2] > 500) {

                return true;
            }
        }

        return false;
    }

    public static double calculateMonthlyAverage(int[] usage) {
        int sum = 0;

        for (int value : usage) {
            sum += value;
        }

        return (double) sum / usage.length;
    }

    public static int countHighConsumptionDays(int[] usage) {
        int count = 0;

        for (int value : usage) {
            if (value > 500) {
                count++;
            }
        }

        return count;
    }

}
