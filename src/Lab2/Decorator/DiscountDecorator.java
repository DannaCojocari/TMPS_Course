package Lab2.Decorator;

import Lab1.FactoryMethod.IProduct;

public class DiscountDecorator extends ProductDecorator{
    private EDiscount discount;

    public DiscountDecorator(IProduct product, EDiscount discount) {
        super(product);
        this.discount = discount;
    }

    @Override
    public String getName() {
        return discount + " Discount " + super.getName();
    }

    @Override
    public double getPrice() {
        switch (discount) {
            case SIMPLE: return super.getPrice() * 0.9;
            case SUPER: return super.getPrice() * 0.75;
            case ULTRA: return super.getPrice() * 0.5;
            default: return super.getPrice();
        }
    }
}
