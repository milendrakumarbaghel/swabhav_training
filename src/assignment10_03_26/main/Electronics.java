package assignment10_03_26.main;

public class Electronics extends Product{
    private int warrantyYears;

    public Electronics(int id, String name, double price, int warrantyYears) {
        super(id, name, price);

        if (warrantyYears < 0)
            throw new IllegalArgumentException("Warranty cannot be negative.");

        this.warrantyYears = warrantyYears;
    }

    @Override
    public void displayProduct() {

        System.out.println("\nElectronics Product");
        System.out.println("ID: " + getProductId());
        System.out.println("Name: " + getProductName());
        System.out.println("Price: " + getBasePrice());
        System.out.println("Warranty: " + warrantyYears + " years");
    }
}
