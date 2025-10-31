package Lab1.FactoryMethod;

import java.util.Arrays;
import java.util.List;

public class BeveragesMenu implements IMenu {
    private final List<IProduct> products;

    public BeveragesMenu() {
        this.products = Arrays.asList(
                new Coffee(),
                new Tea()
        );
    }

    @Override
    public void getMenu() {
        System.out.println(" \n\nBeverages Menu:");
        for (int idx = 0; idx < products.size(); idx++) {
            IProduct p = products.get(idx);
            // If you added units, print them; otherwise simple name/price
            System.out.printf("%d) %s: %dl - %.2f $ %n", idx + 1, p.getName(), p.getGrams(), p.getPrice());
        }
    }

    @Override
    public List<IProduct> getProducts() {
        return products;
    }
}
