package Lab3.State;

import Lab1.FactoryMethod.IProduct;
import Lab1.Singleton.Order;

public class PaidState extends State {

    public PaidState(Order order) {
        super(order);
    }

    @Override
    public void addItem(IProduct product, int quantity) {
        System.out.println("Not allowed. Order already paid.");
    }

    @Override
    public void removeItem(IProduct product) {
        System.out.println("Not allowed. Order already paid.");
    }

    @Override
    public void pay() {
        System.out.println("Already paid");
    }
}
