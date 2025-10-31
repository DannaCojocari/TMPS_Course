package Lab1.FactoryMethod;

public class Eclair implements IProduct {
    private String name = "Eclair";
    private int grams = 150;
    private double price = 7.0;

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