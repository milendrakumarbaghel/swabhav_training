package oops.arrayOfObjects.model;

public class Truck extends Vehicle{
    private double weight;

    public Truck(String vehicleNumber, double weight) {
        super(vehicleNumber);
        this.weight = weight;
    }

    @Override
    public double calculateToll() {
        if(weight<500) {
            return 300;
        }

        return 300 + (weight * 5);
    }
}
