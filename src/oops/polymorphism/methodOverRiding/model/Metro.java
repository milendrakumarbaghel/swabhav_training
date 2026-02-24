package oops.polymorphism.methodOverRiding.model;

public class Metro extends Transport {
    private int stations;
    private static final double RATE_PER_STATION = 10;

    public Metro(double baseFare, int stations) {
        super(baseFare);
        this.stations = stations;
    }

    @Override
    protected double calculateFare() {
        return baseFare + (stations * RATE_PER_STATION);
    }
}
