package oops.encapsulation.model;

import java.util.UUID;
enum ClaimStatus {
    Filed, Approved, Rejected, Settled
};

public class InsuranceClaim {
    private final String claimId;
    private final String  policyNumber;
    private final double claimAmount;
    private double approvedAmount;
    private ClaimStatus claimStatus;

    public InsuranceClaim(String policyNumber, double claimAmount) {
        this.claimId = UUID.randomUUID().toString();

        if (policyNumber.isBlank()) {
            System.out.println("Policy number required");
        }
        this.policyNumber = policyNumber;

        if (claimAmount <= 0) {
            System.out.println("Claim amount must be positive");
        }
        this.claimAmount = claimAmount;

        this.claimStatus = ClaimStatus.Filed;
    }

    public ClaimStatus getClaimStatus() {
        return claimStatus;
    }

    public void claimApprove(double approvedAmount) {
//        ClaimStatus isSettled = getClaimStatus();
        if(claimStatus == ClaimStatus.Settled) {
            System.out.println("Settled claim can't be modified");
            return;
        }

        if (claimStatus != ClaimStatus.Filed) {
            System.out.println("Only filed claims can be approved");
            return;
        }

        if (approvedAmount <= 0 || approvedAmount > claimAmount) {
            System.out.println("Invalid approved amount");
            return;
        }

        this.approvedAmount = approvedAmount;
        this.claimStatus = ClaimStatus.Approved;

        System.out.println("Claim Approved");
    }

    public void rejectClaim() {
//        ClaimStatus isSettled = getClaimStatus();
        if(claimStatus == ClaimStatus.Settled) {
            System.out.println("Settled claim can't be modified");
            return;
        }

        if (claimStatus != ClaimStatus.Filed) {
            System.out.println("Only filed claims can be rejected");
            return;
        }

        this.claimStatus = ClaimStatus.Rejected;

        System.out.println("Claim Rejected");
    }

    public void settleClaim() {
//        ClaimStatus isSettled = getClaimStatus();
        if(claimStatus == ClaimStatus.Settled) {
            System.out.println("Settled claim can't be modified");
            return;
        }

        if(claimStatus != ClaimStatus.Approved) {
            System.out.println("Only approved claims can settled");
            return;
        }

        this.claimStatus = ClaimStatus.Settled;

        System.out.println("Claim Settled");
    }
}
