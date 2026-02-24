package oops.polymorphism.methodOverRiding.model;

public class Taxi extends Transport {
    private double distance;
    private double time; // in minutes

    private static final double RATE_PER_KM = 12;
    private static final double RATE_PER_MINUTE = 2;

    public Taxi(double baseFare, double distance, double time) {
        super(baseFare);
        this.distance = distance;
        this.time = time;
    }

    @Override
    protected double calculateFare() {
        return baseFare + (distance * RATE_PER_KM) + (time * RATE_PER_MINUTE);
    }
}
