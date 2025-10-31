package Lab1.FactoryMethod;

public abstract class MenuFactory {
    public abstract IMenu createMenu();

    void showMenu() {
        IMenu menu = createMenu();
        menu.getMenu();
    }
}