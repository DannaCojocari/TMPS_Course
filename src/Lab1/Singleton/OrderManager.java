package Lab1.Singleton;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private static OrderManager instance;
    private final List<Order> orders;

    private OrderManager() {
        orders = new ArrayList<>();
    }

    public static synchronized OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public double getTotalSales() {
        double totalSales = 0.0;
        for (Order order : orders) {
            totalSales += order.getTotalPrice();
        }
        return totalSales;
    }

    public void showOrders() {
        System.out.println("\nAll Orders:");
        for (Order order : orders) {
            order.getOrderDetails();
        }
        System.out.println("\nTotal Sales: " + getTotalSales() + "$");
    }
}
