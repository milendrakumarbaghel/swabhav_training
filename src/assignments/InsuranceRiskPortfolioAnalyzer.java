package assignments;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InsuranceRiskPortfolioAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter total number of customers: ");
        int n = scanner.nextInt();

        while (n <= 0) {
            System.out.print("Please enter valid number of customers: ");
            n = scanner.nextInt();
        }

        int[] ages = new int[n];
        int[] riskScores = new int[n];

        System.out.println("Enter customers age: ");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }

        System.out.println("Enter customers risk scores: ");
        for (int i = 0; i < n; i++) {
            riskScores[i] = scanner.nextInt();
        }

        String[] riskCategory = classifyCustomers(ages, riskScores);

        countCustomersInEachCategory(riskCategory);

        double averageRisk = calculateAverageRisk(riskScores);
        System.out.println("Average risk score is: " + averageRisk);

        int highestRiskIndex = findHighestRiskCustomerIndex(riskScores);
        System.out.println("Index of highest risk customer: " + highestRiskIndex);

        scanner.close();
    }

    public static String[] classifyCustomers(int[] ages, int[] riskScores) {
        String[] riskCategory = new String[ages.length];

        for (int i = 0; i < ages.length; i++) {

            if (ages[i] < 25 && riskScores[i] > 70) {
                riskCategory[i] = "High Risk Youth";

            } else if (ages[i] >= 60) {
                riskCategory[i] = "Senior Risk";

            } else if (riskScores[i] >= 85) {
                riskCategory[i] = "Very High Risk";

            } else {
                riskCategory[i] = "Normal Risk";
            }
        }

        return riskCategory;
    }

    public static void countCustomersInEachCategory(String[] riskCategory) {
        HashMap<String, Integer> riskCategoryCountMap = new HashMap<>();

        for (String category : riskCategory) {
            riskCategoryCountMap.put(category,
                    riskCategoryCountMap.getOrDefault(category, 0) + 1);
        }

        System.out.println("\nCount of customers in each category:");

        for (Map.Entry<String, Integer> entry : riskCategoryCountMap.entrySet()) {
            System.out.println("Total Customers in Risk Category "
                    + entry.getKey() + " is: " + entry.getValue());
        }
    }

    public static double calculateAverageRisk(int[] riskScores) {
        int sum = 0;

        for (int score : riskScores) {
            sum += score;
        }

        return (double) sum / riskScores.length;
    }

    public static int findHighestRiskCustomerIndex(int[] riskScores) {
        int highestRisk = riskScores[0];
        int index = 0;

        for (int i = 1; i < riskScores.length; i++) {
            if (riskScores[i] > highestRisk) {
                highestRisk = riskScores[i];
                index = i;
            }
        }

        return index;
    }
}