package Lab2.Bridge;

public class VanillaFilling implements IFilling{
    @Override
    public String getName() {
        return "Vanilla";
    }

    @Override
    public double getPrice() {
        return 1.5;
    }

    @Override
    public int getGrams() {
        return 15;
    }
}
