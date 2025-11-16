// Lab2.Composite.ProductLeaf - wraps an IProduct as a packable leaf
package Lab2.Composite;

import Lab1.FactoryMethod.IProduct;

public class ProductLeaf implements IPackage {
    private final IProduct product;

    public ProductLeaf(IProduct product) {
        this.product = product;
    }

    @Override
    public int getWeight() {
        return product.getGrams();
    }

    @Override
    public double getPrice() {
        return product.getPrice();
    }

    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public String getLabel() {
        return String.format("%s (w=%dg, price=%.2f)", getName(), getWeight(), getPrice());
    }
}
