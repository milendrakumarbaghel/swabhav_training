package functionalInterface.consumer;

import java.util.Scanner;
import java.util.function.Consumer;

public class InvoiceFormatter {
    static void main(String[] args) {
        Invoice i1 = new Invoice("Pen", 2, 10);
        Invoice i2 = new Invoice("Notebook", 3, 50);
        Invoice i3 = new Invoice("Pencil", 5, 5);

        Consumer<Invoice> printBill = i -> {
            int total = i.quantity * i.price;
            System.out.println("Item: " + i.itemName +
                    " | Quantity: " + i.quantity +
                    " | Total: ₹" + total);
        };

        printBill.accept(i1);
        printBill.accept(i2);
        printBill.accept(i3);
    }
}
