package Lab3.Strategy;

public class DeliveryContext {
    private DeliveryStrategy strategy;

    public DeliveryContext(DeliveryStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculatePrice(double basePrice) {
        if (strategy == null) {
            throw new IllegalStateException("No strategy selected");
        }
        return strategy.execute(basePrice);
    }
}
