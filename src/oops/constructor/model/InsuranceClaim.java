package oops.constructor.model;

public class InsuranceClaim {
    private static int idCounter = 1000;

    private final int claimId;
    private String policyNumber;
    private double claimAmount;
    private String status;
    private double approvedAmount;

    public InsuranceClaim(String policyNumber, double claimAmount) {

        if (policyNumber == null || policyNumber.isEmpty()) {
            throw new IllegalArgumentException("Policy number required");
        }

        if (claimAmount < 0) {
            throw new IllegalArgumentException("Claim amount cannot be negative");
        }

        this.claimId = ++idCounter;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.status = "Filed";
        this.approvedAmount = 0;
    }

    public int getClaimId() {
        return claimId;
    }

    public String getStatus() {
        return status;
    }

    public double getApprovedAmount() {
        return approvedAmount;
    }

    public void approve(double amount) {
        if (!status.equals("Filed")) {
            System.out.println("Claim cannot be approved");
            return;
        }

        if (amount < 0 || amount > claimAmount) {
            System.out.println("Invalid approval amount");
        }

        this.approvedAmount = amount;
        this.status = "Approved";

        System.out.println("Insurance Approved");
    }
}