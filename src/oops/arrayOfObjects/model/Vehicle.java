package oops.arrayOfObjects.model;

public class Vehicle {
    protected String vehicleNumber;

    public static int totalVehiclesProcessed = 0;
    public static double totalTollCollected = 0;

    public Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        totalVehiclesProcessed++;
    }

    public Vehicle() {

    }

    public double calculateToll() {
        return 0;
    }

    public double calculateToll(double extraCharge) {
        return calculateToll() + extraCharge;
    }

    public void displayVehicleInfo() {
        System.out.println("Vehicle Number: " + vehicleNumber);
    }

    public static void addToll(double amount) {
        totalTollCollected += amount;
    }
}
