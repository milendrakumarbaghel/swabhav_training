package solidPrinciple.inventoryManagementSystem.model.valuationModel;

import solidPrinciple.inventoryManagementSystem.model.productModel.Product;

import java.util.List;

public class LIFOValuation implements ValuationStrategy {
    @Override
    public double calculate(List<Product> products) {
        return products.stream()
                .mapToDouble(p -> p.getQuantity()*p.getPrice())
                .sum();
    }
}
