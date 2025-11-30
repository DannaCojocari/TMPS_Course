package Lab3.Strategy;

public class StandardDelivery implements DeliveryStrategy {
    @Override
    public double execute(double price) {
        return price + 5.0;
    }
}
