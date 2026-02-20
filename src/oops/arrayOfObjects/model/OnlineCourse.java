package oops.arrayOfObjects.model;

public class OnlineCourse extends Course{
    private double platformFee;

    public OnlineCourse(String courseName, double baseFee, double platformFee) {
        super(courseName, baseFee);

        if(platformFee<=0) {
            System.out.println("Enter valid platformFees");
        }
        this.platformFee = platformFee;
    }

    @Override
    public double calculateFee() {
        return baseFee + platformFee;
    }
}
