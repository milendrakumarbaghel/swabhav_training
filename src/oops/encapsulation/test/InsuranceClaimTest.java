package oops.encapsulation.test;

import oops.encapsulation.model.InsuranceClaim;

import java.util.Scanner;

public class InsuranceClaimTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Policy Number: ");
        String policyNumber = scanner.nextLine();

        System.out.print("Enter Claim Amount: ");
        double claimAmount = scanner.nextDouble();

        InsuranceClaim claim = new InsuranceClaim(policyNumber, claimAmount);
        System.out.println("Current Status: " + claim.getClaimStatus());
        int choice;

        do {
            System.out.println("1. Approve Claim");
            System.out.println("2. Reject Claim");
            System.out.println("3. Settle Claim");
            System.out.println("4. Check Status");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Approved Amount: ");
                    double approvedAmount = scanner.nextDouble();
                    claim.claimApprove(approvedAmount);
                    break;

                case 2:
                    claim.rejectClaim();
                    break;

                case 3:
                    claim.settleClaim();
                    break;

                case 4:
                    System.out.println("Current Status: " + claim.getClaimStatus());
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        scanner.close();
    }
}
