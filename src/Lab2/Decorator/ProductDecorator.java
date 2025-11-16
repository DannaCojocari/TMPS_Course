package Lab2.Decorator;

import Lab1.FactoryMethod.IProduct;

public class ProductDecorator implements IProduct {
    private IProduct product;

    public ProductDecorator(IProduct product) {
        this.product = product;
    }

    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public double getPrice() {
        return product.getPrice();
    }

    @Override
    public int getGrams() {
        return product.getGrams();
    }
}


