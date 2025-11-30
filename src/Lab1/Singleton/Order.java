package Lab1.Singleton;

import Lab1.FactoryMethod.IProduct;
import Lab3.Observer.OrderEvent;
import Lab3.Observer.OrderEventType;
import Lab3.Observer.OrderObserver;
import Lab3.State.NewOrderState;
import Lab3.State.State;

import java.util.*;

public class Order {
    private static int nextId = 1;
    private int orderId;
    private List<OrderItem> items;
    private State state;
    private final Map<OrderEventType, List<OrderObserver>> observers = new EnumMap<>(OrderEventType.class);


    public Order() {
        this.orderId = nextId++;
        this.items = new ArrayList<>();
        initObserverMap();
        this.state = new NewOrderState(this);
        notifyObservers(new OrderEvent(OrderEventType.ORDER_CREATED, this, null, "Order created"));
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void addItem(IProduct product, int quantity) {
        this.state.addItem(product, quantity);
    }

    public void removeItem(IProduct product) {
        this.state.removeItem(product);
    }

    public void pay() {
        this.state.pay();
    }

    // ---- Internal helper methods ----
    public void addItemInternal(IProduct product, int quantity) {
        for (OrderItem oi : items) {
            if (oi.getProduct().equals(product)) {
                oi.increaseQuantity(quantity);
                notifyObservers(new OrderEvent(OrderEventType.ITEM_ADDED, this, product, "Quantity increased"));
                return;
            }
        }
        items.add(new OrderItem(product, quantity));
        notifyObservers(new OrderEvent(OrderEventType.ITEM_ADDED, this, product, "New item added"));
    }

    public boolean removeItemInternal(IProduct product) {
        Iterator<OrderItem> it = items.iterator();
        while (it.hasNext()) {
            OrderItem oi = it.next();
            if (oi.getProduct().equals(product)) {
                if (oi.getQuantity() > 1) {
                    oi.decreaseQuantity(1);
                    notifyObservers(new OrderEvent(OrderEventType.ITEM_REMOVED, this, product, "Quantity decreased"));
                    return true;
                }
                it.remove();
                notifyObservers(new OrderEvent(OrderEventType.ITEM_REMOVED, this, product, "Item removed"));
                return true;
            }
        }
        return false;
    }

    public void payInternal() {
        System.out.println("Order " + orderId + " has been paid. Total: " + getTotalPrice() + "$");
        notifyObservers(new OrderEvent(OrderEventType.ORDER_PAID, this, null, "Order has been paid"));
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (OrderItem item : items) {
            totalPrice += item.getItemTotal();
        }
        return totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void getOrderDetails() {
        System.out.println("\nOrder ID: " + orderId);
        for (OrderItem item : items) {
            System.out.println(item.orderItemDetails());
        }

        System.out.println("Total Price: " + getTotalPrice() + "$");
    }

    private void initObserverMap() {
        for (OrderEventType t : OrderEventType.values()) {
            observers.put(t, new ArrayList<>());
        }
    }


    public void subscribeObserver(OrderEventType type, OrderObserver obs) {
        observers.get(type).add(obs);
    }

    public void unsubscribeObserver(OrderEventType type, OrderObserver obs) {
        observers.get(type).remove(obs);
    }

    private void notifyObservers(OrderEvent event) {
        System.out.println();
        List<OrderObserver> list = observers.get(event.getType());
        if (list == null) return;
        for (OrderObserver o : list) {
            o.update(event);
        }
    }
}
