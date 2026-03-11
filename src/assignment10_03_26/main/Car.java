package assignment10_03_26.main;

public class Car extends Vehicle {
    private int numberOfDoors;
    private String fuelType;

    public Car(String regNo, String owner, double charge,
               int numberOfDoors, String fuelType) {

        super(regNo, owner, charge);

        if (numberOfDoors <= 0)
            throw new IllegalArgumentException("Number of doors must be positive.");

        if (fuelType == null || fuelType.trim().isEmpty())
            throw new IllegalArgumentException("Fuel type cannot be empty.");

        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }

    @Override
    public void displayVehicle() {
        System.out.println("\nCar Record");
        System.out.println("Registration No: " + getRegistrationNumber());
        System.out.println("Owner Name: " + getOwnerName());
        System.out.println("Base Charge: " + getBaseUsageCharge());
        System.out.println("Doors: " + numberOfDoors);
        System.out.println("Fuel Type: " + fuelType);
    }
}
