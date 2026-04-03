package solidPrinciple.singleResponsibilityPrinciple.q1;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private Map<Product, Integer> stock = new HashMap<>();

    public void updateStock(Product product, int qty) {
        stock.put(product, stock.getOrDefault(product, 0) + qty);
    }
}
