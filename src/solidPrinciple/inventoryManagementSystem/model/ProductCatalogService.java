package solidPrinciple.inventoryManagementSystem.model;

import solidPrinciple.inventoryManagementSystem.model.productModel.Product;

import java.util.List;
import java.util.Objects;

public class ProductCatalogService {
    public void addProduct(List<Product> products, Product product) {
        Objects.requireNonNull(products, "Product list cannot be null");
        Objects.requireNonNull(product, "Product cannot be null");
        if (containsProduct(products, product.getName())) {
            throw new IllegalArgumentException("Product with this name already exists");
        }
        products.add(product);
    }

    public void deleteProduct(List<Product> products, Product product) {
        Objects.requireNonNull(products, "Product list cannot be null");
        Objects.requireNonNull(product, "Product cannot be null");
        if (!products.remove(product)) {
            throw new IllegalArgumentException("Product not found in inventory");
        }
    }

    private boolean containsProduct(List<Product> products, String name) {
        return products.stream()
                .filter(Objects::nonNull)
                .anyMatch(p -> p.getName().equalsIgnoreCase(name));
    }
}

