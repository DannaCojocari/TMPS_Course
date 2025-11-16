package Lab2.Bridge;

public class ChocolateFilling implements IFilling{
    @Override
    public String getName() {
        return "Chocolate";
    }

    @Override
    public double getPrice() {
        return 2.0;
    }

    @Override
    public int getGrams() {
        return 20;
    }
}
