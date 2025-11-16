// Lab2.Composite.CompositeBox - composite node that may contain boxes or leafs
package Lab2.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompositeBox implements IPackage {
    private final String name;
    private final int weightGrams;
    private final double price;
    private final List<IPackage> children = new ArrayList<>();

    public CompositeBox(String name, int weightGrams, double price) {
        this.name = Objects.requireNonNull(name);
        this.weightGrams = weightGrams;
        this.price = price;
    }

    public void add(IPackage pack) {
        children.add(pack);
    }

    public void remove(IPackage pack) {
        children.remove(pack);
    }

    @Override
    public int getWeight() {
        int sum = weightGrams;
        for (IPackage c : children) sum += c.getWeight();
        return sum;
    }

    @Override
    public double getPrice() {
        double sum = price;
        for (IPackage c : children) sum += c.getPrice();
        return sum;
    }

    @Override
    public String getName() {
        return name;
    }

    // Tree label
    @Override
    public String getLabel() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" (w=").append(getWeight())
                .append("g, price=").append(String.format("%.2f", getPrice())).append(")\n");

        for (IPackage c : children) {
            String childLabel = c.getLabel();
            String indented = childLabel.replaceAll("(?m)^", "  "); // indent 2 spaces
            sb.append(indented).append("\n");
        }
        return sb.toString();
    }
}
