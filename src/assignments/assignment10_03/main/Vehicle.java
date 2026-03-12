package assignments.assignment10_03.main;

public abstract class Vehicle {
    private String registrationNumber;
    private String ownerName;
    private double baseUsageCharge;

    public Vehicle(String registrationNumber, String ownerName, double baseUsageCharge) {

        if (registrationNumber == null || registrationNumber.trim().isEmpty())
            throw new IllegalArgumentException("Registration number cannot be empty.");

        if (ownerName == null || ownerName.trim().isEmpty())
            throw new IllegalArgumentException("Owner name cannot be empty.");

        if (baseUsageCharge < 0)
            throw new IllegalArgumentException("Usage charge cannot be negative.");

        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.baseUsageCharge = baseUsageCharge;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBaseUsageCharge() {
        return baseUsageCharge;
    }

    public abstract void displayVehicle();
}
