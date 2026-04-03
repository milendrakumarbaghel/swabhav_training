package solidPrinciple.inventoryManagementSystem.model;

import solidPrinciple.inventoryManagementSystem.model.productModel.NonPerishableProduct;
import solidPrinciple.inventoryManagementSystem.model.productModel.PerishableProduct;
import solidPrinciple.inventoryManagementSystem.model.productModel.Product;

import java.time.LocalDate;
import java.util.List;

public class ProductOperations {
    private final InventoryService inventoryService;
    private final ProductCatalogService productCatalogService;
    private final InputReader inputReader;
    private final List<Product> products;

    public ProductOperations(InventoryService inventoryService,
                             ProductCatalogService productCatalogService,
                             InputReader inputReader,
                             List<Product> products) {
        this.inventoryService = inventoryService;
        this.productCatalogService = productCatalogService;
        this.inputReader = inputReader;
        this.products = products;
    }

    public void addProduct() {
        String name = inputReader.readProductName("Enter product name: ");
        if (findProductByName(name) != null) {
            System.out.println("Product with this name already exists. Use 'Add Product Stock' instead.");
            return;
        }

        int qty = inputReader.readPositiveInt("Enter quantity: ");
        double price = inputReader.readPositiveDouble("Enter price: ");
        int reOrderQuantity = inputReader.readIntInRange("Enter reorder limit: ", 0, qty);
        String type = inputReader.readYesNo("Is perishable? (yes/no): ");

        try {
            Product product;
            if ("yes".equals(type)) {
                LocalDate expiry = inputReader.readFutureDate("Enter expiry date (yyyy-mm-dd): ");
                product = new PerishableProduct(name, qty, price, expiry, reOrderQuantity);
            } else {
                product = new NonPerishableProduct(name, qty, price, reOrderQuantity);
            }

            productCatalogService.addProduct(products, product);
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
        int newReorderLimit = inputReader.readIntInRange(
                "Enter new reorder limit: ",
                0,
                product.getQuantity()
        );

        try {
            product.setPrice(newPrice);
            product.setReorderLimit(newReorderLimit);
            product.updateTypeSpecificDetails(inputReader);

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
            productCatalogService.deleteProduct(products, product);
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
            System.out.println(
                    p.getName() +
                            " | Type: " + p.getTypeName() +
                            " | Qty: " + p.getQuantity() +
                            " | Price: " + p.getPrice() +
                            " | Reorder Limit: " + p.getReorderLimit() +
                            p.getDisplayExtra()
            );
        }
    }

    private Product findProduct() {
        String name = inputReader.readProductName("Enter product name: ");
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
