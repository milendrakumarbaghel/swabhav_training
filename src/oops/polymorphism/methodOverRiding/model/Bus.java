package oops.polymorphism.methodOverRiding.model;

public class Bus extends Transport {
    private double distance;
    private static final double RATE_PER_KM = 5;

    public Bus(double baseFare, double distance) {
        super(baseFare);
        this.distance = distance;
    }

    @Override
    protected double calculateFare() {
        return baseFare + (distance * RATE_PER_KM);
    }
}
