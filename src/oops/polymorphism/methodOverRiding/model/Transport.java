package oops.polymorphism.methodOverRiding.model;

import java.util.UUID;

public abstract class Transport {
    protected final String routeId;
    protected double baseFare;

    public Transport(double baseFare) {
        this.routeId = UUID.randomUUID().toString();
        this.baseFare = baseFare;
    }

    public void printTicket() {
        double totalFare = calculateFare();

        System.out.println("Route ID: " + routeId);
        System.out.println("Base Fare: ₹" + baseFare);
        System.out.println("Total Fare: ₹" + totalFare);
    }

    protected abstract double calculateFare();
}
