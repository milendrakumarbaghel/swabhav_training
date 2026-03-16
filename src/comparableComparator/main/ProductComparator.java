package comparableComparator.main;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    public int compare(Product p1, Product p2) {
        int category = p1.category.compareTo(p2.category);
        if(category !=0) {
            return category;
        }

        return Double.compare(p1.price, p2.price);
    }
}
