package oops.interfaceDemo.vehicleSystem;

public class Truck implements VehicleControl {
    private boolean isStarted = false;
    private int currentGear = 0;
    private final int MAX_GEAR = 6;

    @Override
    public void start() {
        if (isStarted) {
            System.out.println("Truck already running.");
        } else {
            isStarted = true;
            System.out.println("Truck started with heavy-duty ignition.");
        }
    }

    @Override
    public void stop() {
        if (!isStarted) {
            System.out.println("Truck already stopped.");
        } else {
            isStarted = false;
            currentGear = 0;
            System.out.println("Truck stopped.");
        }
    }

    @Override
    public void changeGear(int gear) {
        if (!isStarted) {
            System.out.println("Start the truck first!");
            return;
        }

        if (gear < 0 || gear > MAX_GEAR) {
            System.out.println("Invalid gear! Truck supports gears 0 to " + MAX_GEAR);
            return;
        }

        currentGear = gear;
        System.out.println("Truck gear changed to: " + gear);
    }
}
