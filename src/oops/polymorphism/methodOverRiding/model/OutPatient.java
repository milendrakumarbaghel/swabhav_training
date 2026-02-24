package oops.polymorphism.methodOverRiding.model;

public class OutPatient extends Patient {
    private double consultationFee;

    public OutPatient(String name, double consultationFee) {
        super(name);
        this.consultationFee = consultationFee;
    }

    @Override
    protected double calculateCharges() {
        System.out.println("\nHospital Bill of OutPatient");
        return consultationFee;
    }
}
