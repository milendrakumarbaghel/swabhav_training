package oops.constructor.test;

import oops.constructor.model.DiscountedOrder;
import oops.constructor.model.Order;
import oops.constructor.model.Product;

import java.util.Scanner;

public class OrderTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();

        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();

        while (price <= 0) {
            System.out.print("Price must be greater than 0. Enter again: ");
            price = scanner.nextDouble();
        }

        System.out.print("Enter Stock Quantity: ");
        int stock = scanner.nextInt();

        Product product = new Product(productId, price, stock);

        System.out.print("Enter Order Type (1-Normal, 2-Discounted): ");
        int type = scanner.nextInt();

        System.out.print("Enter Order Quantity: ");
        int quantity = scanner.nextInt();

        while (quantity <= 0) {
            System.out.print("Quantity must be greater than 0. Enter again: ");
            quantity = scanner.nextInt();
        }

        Order order;

        if (type == 2) {
            System.out.print("Enter Discount Percentage: ");
            double discount = scanner.nextDouble();
            order = new DiscountedOrder(product, quantity, discount);
        } else {
            order = new Order(product, quantity);
        }

        System.out.println("Order Created Successfully!");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Total Amount: ₹" + order.getTotalAmount());

        scanner.close();
    }
}
