package oops.interfaceDemo.model;

public class Speaker implements Controllable {
    @Override
    public void turnOn() {
        System.out.println("Speaker turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Speaker turned OFF");
    }

    @Override
    public void setMode(String mode) {
        System.out.println("Speaker mode set to: " + mode);
    }
}
