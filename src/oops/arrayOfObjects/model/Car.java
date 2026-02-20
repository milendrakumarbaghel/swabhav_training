package oops.arrayOfObjects.model;

public class Car extends Vehicle{
    public Car(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public double calculateToll() {
        return 100;
    }
}
