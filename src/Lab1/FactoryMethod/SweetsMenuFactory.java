package Lab1.FactoryMethod;

public class SweetsMenuFactory extends MenuFactory {
    @Override
    public IMenu createMenu() {
        return new SweetsMenu();
    }
}

