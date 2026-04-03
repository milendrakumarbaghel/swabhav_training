package solidPrinciple.inventoryManagementSystem.model.valuationModel;

import solidPrinciple.inventoryManagementSystem.model.productModel.Product;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductTypeValuationPolicy implements ValuationPolicy {
    private final String label;
    private final Class<? extends Product> productType;
    private final ValuationStrategy strategy;

    public ProductTypeValuationPolicy(String label, Class<? extends Product> productType, ValuationStrategy strategy) {
        this.label = Objects.requireNonNull(label, "Policy label cannot be null");
        this.productType = Objects.requireNonNull(productType, "Product type cannot be null");
        this.strategy = Objects.requireNonNull(strategy, "Valuation strategy cannot be null");
    }

    @Override
    public String label() {
        return label;
    }

    @Override
    public double calculate(List<Product> products) {
        Objects.requireNonNull(products, "Product list cannot be null");
        List<Product> filteredProducts = products.stream()
                .filter(Objects::nonNull)
                .filter(productType::isInstance)
                .collect(Collectors.toList());
        return strategy.calculate(filteredProducts);
    }
}

