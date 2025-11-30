package Lab3.Strategy;

public class FreeDelivery implements DeliveryStrategy{
    @Override
    public double execute(double price) {
        return price;
    }
}
