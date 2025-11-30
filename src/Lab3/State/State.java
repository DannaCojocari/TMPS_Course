package Lab3.State;

import Lab1.FactoryMethod.IProduct;
import Lab1.Singleton.Order;

public abstract class State {
    protected final Order order;

    public State(Order order) {
        this.order = order;
    }

    public abstract void addItem(IProduct product, int quantity);
    public abstract void removeItem(IProduct product);
    public abstract void pay();
}
