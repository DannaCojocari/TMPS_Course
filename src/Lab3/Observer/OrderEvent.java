package Lab3.Observer;

import Lab1.FactoryMethod.IProduct;
import Lab1.Singleton.Order;

public class OrderEvent {
    private final OrderEventType type;
    private final Order order;
    private final IProduct product;
    private final String message;

    public OrderEvent(OrderEventType type, Order order, IProduct product, String message) {
        this.type = type;
        this.order = order;
        this.product = product;
        this.message = message;
    }

    public OrderEventType getType() { return type; }
    public Order getOrder() { return order; }
    public IProduct getProduct() { return product; }
    public String getMessage() { return message; }
}
