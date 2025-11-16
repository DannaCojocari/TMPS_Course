package Lab2.Bridge;

import Lab1.FactoryMethod.IProduct;

// Abstraction
public class ProductFilling implements IProduct {
    private IProduct product;
    private IFilling filling;

    public ProductFilling(IProduct product, IFilling filling) {
        this.product = product;
        this.filling = filling;
    }

    @Override
    public String getName() {
        return product.getName() + " with " + filling.getName();
    }

    @Override
    public double getPrice() {
        return product.getPrice() + filling.getPrice();
    }

    @Override
    public int getGrams() {
        return product.getGrams() + filling.getGrams();
    }
}
