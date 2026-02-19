package oops.constructor.test;

import oops.constructor.model.CorporateClaim;
import oops.constructor.model.InsuranceClaim;

import java.util.Scanner;

public class InsuranceClaimTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Claim Type (1-Normal, 2-Corporate): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Policy Number: ");
        String policyNumber = scanner.nextLine();

        while (policyNumber.isBlank()) {
            System.out.print("Policy number cannot be blank. Enter again: ");
            policyNumber = scanner.nextLine();
        }

        System.out.print("Enter Claim Amount: ");
        double claimAmount = scanner.nextDouble();

        while (claimAmount <= 0) {
            System.out.print("Claim amount must be positive. Enter again: ");
            claimAmount = scanner.nextDouble();
        }

        InsuranceClaim claim;

        if (type == 2) {
            claim = new CorporateClaim(policyNumber, claimAmount);
        } else {
            claim = new InsuranceClaim(policyNumber, claimAmount);
        }

        int choice;

        do {
            System.out.println("\n1. Approve Claim");
            System.out.println("2. Check Status");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Approved Amount: ");
                    double approvedAmount = scanner.nextDouble();
                    claim.approve(approvedAmount);
                    break;

                case 2:
                    System.out.println("Current Status: " + claim.getStatus());
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 3);

        scanner.close();
    }
}
