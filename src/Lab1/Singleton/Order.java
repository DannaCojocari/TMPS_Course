package Lab1.Singleton;

import Lab1.FactoryMethod.IProduct;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextId = 1;
    private int orderId;
    private List<OrderItem> items;

    public Order() {
        this.orderId = nextId++;
        this.items = new ArrayList<>();
    }

    public void addItem(IProduct product, int quantity) {
        items.add(new OrderItem(product, quantity));
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (OrderItem item : items) {
            totalPrice += item.getItemTotal();
        }
        return totalPrice;
    }

    public void getOrderDetails() {
        System.out.println("\nOrder ID: " + orderId);
        for (OrderItem item : items) {
            System.out.println(item.orderItemDetails());
        }

        System.out.println("Total Price: " + getTotalPrice());
    }
}
