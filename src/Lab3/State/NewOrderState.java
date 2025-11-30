package Lab3.State;

import Lab1.FactoryMethod.IProduct;
import Lab1.Singleton.Order;

public class NewOrderState extends State{

    public NewOrderState(Order order) {
        System.out.print("New Order State Initialized");
        super(order);
    }

    @Override
    public void addItem(IProduct product, int quantity) {
        order.addItemInternal(product, quantity);
        System.out.print("Added product " + product.getName() + " (x" + quantity + ")");
    }

    @Override
    public void removeItem(IProduct product) {
        boolean removed = order.removeItemInternal(product);
        if (removed) {
            System.out.println("Removed product " + product.getName());
        } else {
            System.out.println("Product not found: " + product.getName());
        }
    }

    @Override
    public void pay() {
        order.payInternal();
        order.changeState(new PaidState(order));
    }
}
