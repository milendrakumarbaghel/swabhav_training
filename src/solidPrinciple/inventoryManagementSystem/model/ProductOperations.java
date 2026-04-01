package solidPrinciple.inventoryManagementSystem.model;

import solidPrinciple.inventoryManagementSystem.model.productModel.NonPerishableProduct;
import solidPrinciple.inventoryManagementSystem.model.productModel.PerishableProduct;
import solidPrinciple.inventoryManagementSystem.model.productModel.Product;

import java.time.LocalDate;
import java.util.List;

public class ProductOperations {
    private final InventoryService inventoryService;
    private final InputReader inputReader;
    private final List<Product> products;

    public ProductOperations(InventoryService inventoryService, InputReader inputReader, List<Product> products) {
        this.inventoryService = inventoryService;
        this.inputReader = inputReader;
        this.products = products;
    }

    public void addProduct() {
        String name = inputReader.readNonEmptyString("Enter product name: ");
        if (findProductByName(name) != null) {
            System.out.println("Product with this name already exists. Use 'Add Product Stock' instead.");
            return;
        }

        int qty = inputReader.readPositiveInt("Enter quantity: ");
        double price = inputReader.readPositiveDouble("Enter price: ");
        int reOrderQuantity = inputReader.readNonNegativeInt("Enter reorder limit: ");
        String type = inputReader.readYesNo("Is perishable? (yes/no): ");

        try {
            Product product;
            if ("yes".equals(type)) {
                LocalDate expiry = inputReader.readFutureDate("Enter expiry date (yyyy-mm-dd): ");
                product = new PerishableProduct(name, qty, price, expiry, reOrderQuantity);
            } else {
                product = new NonPerishableProduct(name, qty, price, reOrderQuantity);
            }

            inventoryService.addProduct(products, product);
            System.out.println("Product added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Unable to add product: " + e.getMessage());
        }
    }

    public void updateProduct() {
        if (products.isEmpty()) {
            System.out.println("No products available to update.");
            return;
        }

        Product product = findProduct();
        if (product == null) {
            return;
        }

        double newPrice = inputReader.readPositiveDouble("Enter new price: ");
        int newReorderLimit = inputReader.readNonNegativeInt("Enter new reorder limit: ");

        try {
            product.setPrice(newPrice);
            product.setReorderLimit(newReorderLimit);

            if (product instanceof PerishableProduct) {
                LocalDate newExpiry = inputReader.readFutureDate("Enter new expiry date (yyyy-mm-dd): ");
                ((PerishableProduct) product).setExpiryDate(newExpiry);
            }

            System.out.println("Product updated successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Unable to update product: " + e.getMessage());
        }
    }

    public void deleteProduct() {
        if (products.isEmpty()) {
            System.out.println("No products available to delete.");
            return;
        }

        Product product = findProduct();
        if (product == null) {
            return;
        }

        try {
            inventoryService.deleteProduct(products, product);
            System.out.println("Product deleted successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Unable to delete product: " + e.getMessage());
        }
    }

    public void addProductStock() {
        if (products.isEmpty()) {
            System.out.println("No products available. Add product first.");
            return;
        }

        Product product = findProduct();
        if (product == null) {
            return;
        }

        int qty = inputReader.readPositiveInt("Enter quantity to add: ");

        try {
            inventoryService.addStock(product, qty);
        } catch (IllegalArgumentException e) {
            System.out.println("Unable to add stock: " + e.getMessage());
        }
    }

    public void removeProductStock() {
        if (products.isEmpty()) {
            System.out.println("No products available to remove stock.");
            return;
        }

        Product product = findProduct();
        if (product == null) {
            return;
        }

        int qty = inputReader.readPositiveInt("Enter quantity to remove: ");

        try {
            inventoryService.removeStock(product, qty);
        } catch (IllegalArgumentException e) {
            System.out.println("Unable to remove stock: " + e.getMessage());
        }
    }

    public void showProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }

        for (Product p : products) {
            String type = p instanceof PerishableProduct ? "Perishable" : "Non-Perishable";
            String extra = "";
            if (p instanceof PerishableProduct) {
                extra = " | Expiry: " + ((PerishableProduct) p).getExpiryDate();
            }

            System.out.println(
                    p.getName() +
                            " | Type: " + type +
                            " | Qty: " + p.getQuantity() +
                            " | Price: " + p.getPrice() +
                            " | Reorder Limit: " + p.getReorderLimit() +
                            extra
            );
        }
    }

    private Product findProduct() {
        String name = inputReader.readNonEmptyString("Enter product name: ");
        Product product = findProductByName(name);

        if (product == null) {
            System.out.println("Product not found!");
        }
        return product;
    }

    private Product findProductByName(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name.trim())) {
                return p;
            }
        }
        return null;
    }
}
