package Lab1.FactoryMethod;

public class CinnamonBuns implements IProduct {
    private String name = "Cinnamon Buns";
    private int grams = 250;
    private double price = 12.5;

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

