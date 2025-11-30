package Lab3;

import Lab1.FactoryMethod.CinnamonBuns;
import Lab1.FactoryMethod.Coffee;
import Lab1.FactoryMethod.IProduct;
import Lab1.FactoryMethod.Tea;
import Lab1.Singleton.Order;
import Lab3.Observer.KitchenObserver;
import Lab3.Observer.LoggerObserver;
import Lab3.Observer.OrderEventType;
import Lab3.Strategy.DeliveryContext;
import Lab3.Strategy.FreeDelivery;
import Lab3.Strategy.StandardDelivery;
import Lab3.Strategy.WeekendDelivery;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- State Pattern ---");
        Order order = new Order();
        IProduct cinnamonBuns = new CinnamonBuns();
        IProduct coffee = new Coffee();
        IProduct tea = new Tea();

        order.addItem(cinnamonBuns, 2);
        order.addItem(coffee, 2);
        order.addItem(coffee, 1);
        order.removeItem(coffee);
        order.removeItem(tea);
        order.getOrderDetails();

        System.out.println();
        order.pay();

        // Attempt to modify after payment
        order.addItem(cinnamonBuns, 1);
        order.removeItem(coffee);


        System.out.println("\n\n--- Observer Pattern ---");
        Order order1 = new Order();

        KitchenObserver kitchen = new KitchenObserver();
        LoggerObserver logger = new LoggerObserver();

        order1.subscribeObserver(OrderEventType.ITEM_ADDED, kitchen);
        order1.subscribeObserver(OrderEventType.ITEM_REMOVED, kitchen);

        for (OrderEventType t : OrderEventType.values()) {
            order1.subscribeObserver(t, logger);
        }

        IProduct buns = new CinnamonBuns();
        IProduct coffee1 = new Coffee();

        order1.addItem(buns, 1);

        System.out.println();
        order1.addItem(coffee1, 2);

        System.out.println();
        order1.removeItem(coffee1);

        System.out.println();
        order1.pay();

        System.out.println("\n\n--- Strategy Pattern ---");
        double orderPrice = order1.getTotalPrice();

        DeliveryContext standardDelivery = new DeliveryContext(new StandardDelivery());
        System.out.println("Standard delivery fee (+5$): " + standardDelivery.calculatePrice(orderPrice) + "$");

        DeliveryContext weekendDelivery = new DeliveryContext(new WeekendDelivery());
        System.out.println("Weekend delivery fee (+ 10%): " + weekendDelivery.calculatePrice(orderPrice) + "$");

        DeliveryContext freeDelivery = new DeliveryContext(new FreeDelivery());
        System.out.println("Free delivery: " + freeDelivery.calculatePrice(orderPrice) + "$");
    }
}
