package Lab3.Observer;

public class LoggerObserver implements OrderObserver {

    @Override
    public void update(OrderEvent event) {
        // Logger prints every event type in a concise form
        System.out.println("Logger: Event=" + event.getType() +
                ", OrderId=" + event.getOrder().getOrderId() +
                (event.getProduct() != null ? ", Product=" + event.getProduct().getName() : "") +
                (event.getMessage() != null ? ", Msg=" + event.getMessage() : ""));
    }
}
