package Lab0;

class Cashier extends Employee {
    public Cashier(String name, String surname) {
        super(name, surname, "Cashier", 800);
    }

    @Override
    public void work() {
        System.out.println("The cashier is working.");
    }

    public void processPayment(IProduct product) {
        System.out.println("Processing payment of " + product.price() + "$ for " + product.getName());
    }
}