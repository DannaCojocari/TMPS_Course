package Lab1.FactoryMethod;

public class BeveragesMenuFactory extends MenuFactory {
    @Override
    public IMenu createMenu() {
        return new BeveragesMenu();
    }
}
