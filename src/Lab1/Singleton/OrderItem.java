package Lab1.Singleton;


import Lab1.FactoryMethod.IProduct;

public class OrderItem {
    private IProduct product;
    private int quantity;

    public OrderItem(IProduct product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getItemTotal() {
        return product.getPrice() * quantity;
    }

    public String orderItemDetails() {
        return product.getName() + " x" + quantity + " = " + product.getPrice() + "$";
    }
}
