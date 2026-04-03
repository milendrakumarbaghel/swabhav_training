package solidPrinciple.inventoryManagementSystem.model.valuationModel;

import solidPrinciple.inventoryManagementSystem.model.productModel.Product;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class InventoryValuationService {
    private final List<ValuationPolicy> policies;

    public InventoryValuationService(List<ValuationPolicy> policies) {
        this.policies = List.copyOf(Objects.requireNonNull(policies, "Valuation policies cannot be null"));
        if (this.policies.isEmpty()) {
            throw new IllegalArgumentException("At least one valuation policy is required");
        }
    }

    public Map<String, Double> calculateByPolicy(List<Product> products) {
        Objects.requireNonNull(products, "Product list cannot be null");
        Map<String, Double> result = new LinkedHashMap<>();
        for (ValuationPolicy policy : policies) {
            result.put(policy.label(), policy.calculate(products));
        }
        return result;
    }

    public double calculateTotal(List<Product> products) {
        return calculateByPolicy(products).values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}

