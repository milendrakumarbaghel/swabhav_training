package oops.interfaceDemo.model;

public class TV implements Controllable {
    @Override
    public void turnOn() {
        System.out.println("TV turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TV turned OFF");
    }

    @Override
    public void setMode(String mode) {
        System.out.println("TV mode set to: " + mode);
    }
}
