package Lab1.FactoryMethod;

public class Tea implements IProduct {
    private String name = "Tea";
    private int grams = 300;
    private double price = 3.0;

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
