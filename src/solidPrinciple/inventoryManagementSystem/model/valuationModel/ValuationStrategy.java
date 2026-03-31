package solidPrinciple.inventoryManagementSystem.model.valuationModel;

import solidPrinciple.inventoryManagementSystem.model.productModel.Product;

import java.util.List;

public interface ValuationStrategy {
    double calculate(List<Product> products);
}
