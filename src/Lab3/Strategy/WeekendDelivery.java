package Lab3.Strategy;

public class WeekendDelivery implements DeliveryStrategy {
    @Override
    public double execute(double price) {
        return price * 1.1;
    }
}
