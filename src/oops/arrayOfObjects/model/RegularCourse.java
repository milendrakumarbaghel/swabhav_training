package oops.arrayOfObjects.model;

public class RegularCourse extends Course {
    private double labFee;
    private double libraryFee;
    private double cautionMoney;

    public RegularCourse(String courseName, double baseFee, double labFee, double libraryFee, double cautionMoney) {
        super(courseName, baseFee);

        if(labFee<=0) {
            System.out.println("Enter valid lab fee (greater than zero)");
            return;
        }
        this.labFee = labFee;

        if(libraryFee<=0) {
            System.out.println("Enter valid library fee (greater than zero)");
            return;
        }
        this.libraryFee = libraryFee;

        if(cautionMoney<=0) {
            System.out.println("Enter valid caution money (greater than zero)");
            return;
        }
        this.cautionMoney = cautionMoney;
    }

    @Override
    public double calculateFee() {
        return baseFee + labFee + libraryFee + cautionMoney;
    }
}
