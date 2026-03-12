package assignments.assignment10_03.main;

public class Bike extends Vehicle{
    private int engineCapacity;
    private boolean hasGear;

    public Bike(String regNo, String owner, double charge,
                int engineCapacity, boolean hasGear) {

        super(regNo, owner, charge);

        if (engineCapacity <= 0)
            throw new IllegalArgumentException("Engine capacity must be positive.");

        this.engineCapacity = engineCapacity;
        this.hasGear = hasGear;
    }

    @Override
    public void displayVehicle() {
        System.out.println("\nBike Record");
        System.out.println("Registration No: " + getRegistrationNumber());
        System.out.println("Owner Name: " + getOwnerName());
        System.out.println("Base Charge: " + getBaseUsageCharge());
        System.out.println("Engine Capacity: " + engineCapacity + " cc");
        System.out.println("Gear System: " + (hasGear ? "Yes" : "No"));
    }
}
