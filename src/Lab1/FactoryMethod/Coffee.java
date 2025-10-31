package Lab1.FactoryMethod;

public class Coffee implements IProduct {
    private String name = "Coffee";
    private int grams = 250;
    private double price = 3.75;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getGrams() {
        return grams;
    }
}
