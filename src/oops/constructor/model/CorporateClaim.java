package oops.constructor.model;

public class CorporateClaim extends InsuranceClaim {
    private static final double PROCESSING_FEE = 500;
    private double processingFee;

    public CorporateClaim(String policyNumber, double claimAmount) {

        super(policyNumber, claimAmount);

        this.processingFee = PROCESSING_FEE;
    }

    public double getProcessingFee() {
        return processingFee;
    }
}