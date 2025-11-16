package Lab2.Decorator;

import Lab1.FactoryMethod.IProduct;

public class ToppingDecorator extends ProductDecorator {
    private EToppings topping;


    public ToppingDecorator(IProduct product, EToppings topping) {
        super(product);
        this.topping = topping;
    }

    @Override
    public String getName() {
        return topping + " " + super.getName();
    }

    @Override
    public double getPrice() {
        double price = 0;

        switch (this.topping) {
            case Whipped_Cream, Chocolate_Chips, Almond_Granola, Nutella:
                price = 0.5;
                break;
            case Caramel_Syrup, Sprinkles, Marshmallow, Peanut_Butter:
                price = 0.3;
                break;
            case Strawberry_Fluff:
                price= 0.7;
                break;
            default:
                throw new IllegalArgumentException("Invalid topping " + this.topping);
        }

        return price + super.getPrice();
    }

    @Override
    public int getGrams() {
        int grams = 0;

        switch (this.topping) {
            case Whipped_Cream, Chocolate_Chips, Almond_Granola, Nutella:
                grams = 10;
                break;
            case Caramel_Syrup, Sprinkles, Marshmallow, Peanut_Butter:
                grams = 5;
                break;
            case Strawberry_Fluff:
                grams= 15;
                break;
            default:
                throw new IllegalArgumentException("Invalid topping " + this.topping);
        }
        return grams + super.getGrams();
    }
}
