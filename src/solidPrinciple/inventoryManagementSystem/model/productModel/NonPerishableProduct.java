package solidPrinciple.inventoryManagementSystem.model.productModel;

public class NonPerishableProduct extends Product{
    public NonPerishableProduct(String name, int quantity, double price, int reOrderLimit) {
        super(name, quantity, price, reOrderLimit);
    }
}
