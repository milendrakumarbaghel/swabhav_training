package assignments.assignment10_03.main;

public class Clothing extends Product{
    private String size;
    private String fabricType;

    public Clothing(int id, String name, double price, String size, String fabricType) {
        super(id, name, price);

        if (size == null || size.trim().isEmpty())
            throw new IllegalArgumentException("Size cannot be empty.");

        if (fabricType == null || fabricType.trim().isEmpty())
            throw new IllegalArgumentException("Fabric type cannot be empty.");

        this.size = size;
        this.fabricType = fabricType;
    }

    @Override
    public void displayProduct() {

        System.out.println("\nClothing Product");
        System.out.println("ID: " + getProductId());
        System.out.println("Name: " + getProductName());
        System.out.println("Price: " + getBasePrice());
        System.out.println("Size: " + size);
        System.out.println("Fabric: " + fabricType);
    }
}
