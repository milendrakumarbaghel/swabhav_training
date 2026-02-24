package oops.interfaceDemo.model;

public class Bike implements Vehicle {
    private String fuel;

    public Bike() {
        this.fuel = "Petrol";
        System.out.println("Bike object created with default fuel: Petrol");
    }

    @Override
    public void start() {
        System.out.println("Bike is starting");
    }

    @Override
    public void stop() {
        System.out.println("Bike is stopping");
    }

    @Override
    public String fuelType() {
        return fuel;
    }
}
