package oops.polymorphism.methodOverRiding.model;

public class EmergencyPatient extends Patient {
    private double treatmentCharges;
    private double emergencySurcharge;

    public EmergencyPatient(String name, double treatmentCharges, double emergencySurcharge) {
        super(name);
        this.treatmentCharges = treatmentCharges;
        this.emergencySurcharge = emergencySurcharge;
    }

    @Override
    protected double calculateCharges() {
        System.out.println("\nHospital Bill of EmergencyPatient");
        return treatmentCharges + emergencySurcharge;
    }
}
