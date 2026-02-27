package oops.interfaceDemo.vehicleSystem;

public class Bike implements VehicleControl {
    private boolean isStarted = false;
    private int currentGear = 0;
    private final int MAX_GEAR = 4;

    @Override
    public void start() {
        if (isStarted) {
            System.out.println("Bike already running.");
        } else {
            isStarted = true;
            System.out.println("Bike started.");
        }
    }

    @Override
    public void stop() {
        if (!isStarted) {
            System.out.println("Bike already stopped.");
        } else {
            isStarted = false;
            currentGear = 0;
            System.out.println("Bike stopped.");
        }
    }

    @Override
    public void changeGear(int gear) {
        if (!isStarted) {
            System.out.println("Start the bike first!");
            return;
        }

        if (gear < 0 || gear > MAX_GEAR) {
            System.out.println("Invalid gear! Bike supports gears 0 to " + MAX_GEAR);
            return;
        }

        currentGear = gear;
        System.out.println("Bike gear changed to: " + gear);
    }
}
