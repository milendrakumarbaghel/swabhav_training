package oops.interfaceDemo.vehicleSystem;

public class Car implements VehicleControl {
    private boolean isStarted = false;
    private int currentGear = 0;
    private final int MAX_GEAR = 5;

    @Override
    public void start() {
        if (isStarted) {
            System.out.println("Car is already started.");
        } else {
            isStarted = true;
            System.out.println("Car started.");
        }
    }

    @Override
    public void stop() {
        if (!isStarted) {
            System.out.println("Car is already stopped.");
        } else {
            isStarted = false;
            currentGear = 0;
            System.out.println("Car stopped.");
        }
    }

    @Override
    public void changeGear(int gear) {
        if (!isStarted) {
            System.out.println("Start the car first!");
            return;
        }

        if (gear < 0 || gear > MAX_GEAR) {
            System.out.println("Invalid gear! Car supports gears 0 to " + MAX_GEAR);
            return;
        }

        currentGear = gear;
        System.out.println("Car gear changed to: " + gear);
    }
}
