package functionalInterface.consumer;

public class Invoice {
    String itemName;
    int quantity;
    int price;

    Invoice(String itemName, int quantity, int price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }
}
