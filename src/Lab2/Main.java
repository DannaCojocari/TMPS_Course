package Lab2;

import Lab1.FactoryMethod.*;
import Lab2.Bridge.*;
import Lab2.Decorator.*;
import Lab2.Composite.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Decorator Pattern
        System.out.println("Decorator Pattern:");
        IProduct cinnamonBuns = new Eclair();
        System.out.println(cinnamonBuns.getName() +  ": " + cinnamonBuns.getGrams() + "g " + " - " + cinnamonBuns.getPrice() + "$");

        IProduct toppingCinnamonBuns = new ToppingDecorator(cinnamonBuns, EToppings.Caramel_Syrup);
        System.out.println(toppingCinnamonBuns.getName() +  ": " + toppingCinnamonBuns.getGrams() + "g " + " - " + toppingCinnamonBuns.getPrice() + "$");

        IProduct discountCinnamonBuns = new DiscountDecorator(toppingCinnamonBuns, EDiscount.SUPER);
        System.out.println(discountCinnamonBuns.getName() +  ": " + discountCinnamonBuns.getGrams() + "g " + " - " + discountCinnamonBuns.getPrice() + "$");

        // Bridge Pattern
        System.out.println("\nBridge Pattern:");
        IProduct eclair = new Eclair();
        System.out.println(eclair.getName() +  ": " + eclair.getGrams() + "g " + " - " + eclair.getPrice() + "$");

        IFilling filling = new ChocolateFilling();
        System.out.println(filling.getName() +  ": " + filling.getGrams() + "g " + filling.getPrice() + "$");

        IProduct filledEclair = new ProductFilling(eclair, filling);
        System.out.println(filledEclair.getName() +  ": " + filledEclair.getGrams() + "g " + filledEclair.getPrice() + "$");

        // Composite Pattern
        System.out.println("\nComposite Pattern");
        List<IProduct> products = List.of(
                new Eclair(),
                new ProductFilling(new CinnamonBuns(), new ChocolateFilling()),
                new ToppingDecorator(new Eclair(), EToppings.Whipped_Cream),
                new Eclair(),
                new ToppingDecorator(new Eclair(), EToppings.Nutella)
        );

        List<ProductLeaf> leaves = new ArrayList<>();

        for (IProduct product : products) {
            leaves.add(new ProductLeaf(product));
        }

        List<CompositeBox> smallBoxes = new ArrayList<>();
        int maxItemsPerSmallBox = 2;
        CompositeBox currentBox = null;
        int count = 0;
        int boxNumber = 1;

        for (ProductLeaf leaf : leaves) {
            if (currentBox == null || count >= maxItemsPerSmallBox) {
                currentBox = new CompositeBox("Small Box #" + boxNumber++, 10, 0.20);
                smallBoxes.add(currentBox);
                count = 0;
            }
            currentBox.add(leaf);
            count++;
        }

        CompositeBox bigBox = new CompositeBox("Big Box", 100, 1.0);

        for (CompositeBox sp : smallBoxes) {
            bigBox.add(sp);
        }

        System.out.println(bigBox.getLabel());
    }
}
