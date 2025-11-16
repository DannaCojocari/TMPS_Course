package Lab2.Composite;

public class Box implements IPackage{
    private final String name;
    private final int weightGrams;
    private final double price;

    public Box(String name, int weightGrams, double price) {
        this.name = name;
        this.weightGrams = weightGrams;
        this.price = price;
    }

    @Override
    public int getWeight() {
        return weightGrams;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLabel() {
        return String.format("%s (w=%dg, price=%.2f)", getName(), getWeight(), getPrice());
    }
}
