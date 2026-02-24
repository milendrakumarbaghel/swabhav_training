package oops.interfaceDemo.model;

import java.util.Scanner;

public class Car implements Vehicle {
    private String fuel;

    public Car(String fuel) {
        this.fuel = readValidFuelType(fuel);
        System.out.println("Car object created with fuel type: " + fuel);
    }

    @Override
    public void start() {
        System.out.println("Car is starting");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping");
    }

    @Override
    public String fuelType() {
        return fuel;
    }

    public static String readValidFuelType(String fuel) {
        while (!(fuel.equalsIgnoreCase("Petrol") || fuel.equalsIgnoreCase("Diesel"))) {
            System.out.print("Invalid fuel type. Enter Petrol or Diesel: ");
        }

        return fuel;
    }
}
