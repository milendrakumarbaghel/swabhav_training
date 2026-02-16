package assignments;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SmartLoanEligibilityChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter total no of Applicants: ");
        int n = scanner.nextInt();

        while(n<=0) {
            System.out.println("Please provide valid applicant number: ");
            n = scanner.nextInt();
        }

        int[] creditScores = new int[n];
        int[] monthlyIncomes = new int[n];
        int[] existingLoans = new int[n];

        System.out.println("Enter credit scores of Applicants: ");
        for(int i=0; i<n; i++) {
            creditScores[i] = scanner.nextInt();
        }

        System.out.println("Enter monthly incomes of Applicants: ");
        for(int i=0; i<n; i++) {
            monthlyIncomes[i] = scanner.nextInt();
        }

        System.out.println("Enter number of loans taken by Applicants: ");
        for(int i=0; i<n; i++) {
            existingLoans[i] = scanner.nextInt();
        }

        String[] eligibilityResult = loanEligibilityChecker(creditScores, monthlyIncomes, existingLoans);

        System.out.println("Status of Loan Applicants is: ");
        for(int i=0; i<n; i++) {
            System.out.println("Applicant " + i+1 + "is " + eligibilityResult[i]);
        }

        countApprovalAndRejections(eligibilityResult);

        int bestApplicant = findBestApplicantProfile(creditScores, monthlyIncomes);
        System.out.println("Applicant with best approval profile is applicant no: "+bestApplicant);

    }

    public static String[] loanEligibilityChecker(int[] creditScores, int[] monthlyIncomes, int[] existingLoans) {
        int n = creditScores.length;
        String[] eligibilityResult = new String[n];

        for(int i=0; i<n; i++) {
            if(creditScores[i]<600 && monthlyIncomes[i]<25000 && existingLoans[i]>=3) {
                eligibilityResult[i] = "Rejected";
            } else if(creditScores[i]>=800 && monthlyIncomes[i]>100000) eligibilityResult[i] = "Instant Approval";
            else eligibilityResult[i] = "Standard Review";
        }

        return eligibilityResult;
    }

    public static void countApprovalAndRejections(String[] eligibilityResult) {
        HashMap<String, Integer> approvalsAndRejectionsCountMap = new HashMap<>();

        for(String str : eligibilityResult) {
            approvalsAndRejectionsCountMap.put(str, approvalsAndRejectionsCountMap.getOrDefault(str, 0)+1);
        }

        System.out.println("\nCount of Applicants in each category:");
        for (Map.Entry<String, Integer> entry : approvalsAndRejectionsCountMap.entrySet()) {
            System.out.println("Total Applicant "
                    + entry.getKey() + " is: " + entry.getValue());
        }
    }

    public static int findBestApplicantProfile(int[] creditScores, int[] monthlyIncomes) {
        int n = creditScores.length;
        int maxCreditScore = 0;
        int maxIncome = 0;
        int bestApplicantNo = 0;

        for(int i=0; i<n; i++) {
            if(creditScores[i]>maxCreditScore && monthlyIncomes[i]>maxIncome) {
                maxCreditScore = creditScores[i];
                maxIncome = monthlyIncomes[i];
                bestApplicantNo = i;
            }
        }

        return bestApplicantNo;
    }
}
