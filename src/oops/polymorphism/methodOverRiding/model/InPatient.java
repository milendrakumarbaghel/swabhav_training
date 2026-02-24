package oops.polymorphism.methodOverRiding.model;

public class InPatient extends Patient {
    private double roomCharges;
    private double treatmentCharges;

    public InPatient(String name, double roomCharges, double treatmentCharges) {
        super(name);
        this.roomCharges = roomCharges;
        this.treatmentCharges = treatmentCharges;
    }

    @Override
    protected double calculateCharges() {
        System.out.println("\nHospital Bill of InPatient");
        return roomCharges + treatmentCharges;
    }
}
