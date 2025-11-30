package Lab3.Observer;

public class KitchenObserver implements OrderObserver {

    @Override
    public void update(OrderEvent event) {
        if (event.getType() == OrderEventType.ITEM_ADDED) {
            System.out.println("Kitchen: Item added -> " + event.getProduct().getName());
        } else if (event.getType() == OrderEventType.ITEM_REMOVED) {
            System.out.println("Kitchen: Item removed ->" + event.getProduct().getName());
        }
    }
}
