package Lab0;

public class Main {
    public static void main(String[] args) {
        Employee baker = new Baker("John", "Smith");
        Employee cashier = new Cashier("Anna", "Brown");

        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.addEmployee(baker);
        employeeManager.addEmployee(cashier);

        IProduct cinnamonBuns = new CinnamonBuns();
        IProduct muffin = new Muffin();

        BakeryInventory inventory = new BakeryInventory();
        inventory.addProduct(cinnamonBuns);
        inventory.addProduct(muffin);

        Bakery bakery = new Bakery("Sweet Moments", employeeManager, inventory);

        System.out.println("Welcome to " + bakery.getName() + " Bakery!");
        for (Employee e : bakery.getEmployeeManager().getEmployees()) {
            System.out.println("- " + e.getRole() + ": " + e.getName());
            e.work();
        }

        System.out.println("\nProducts in stock:");
        for (IProduct p : bakery.getInventory().getProducts()) {
            System.out.println("- " + p.getName() + " | Price: " + p.price() + "$");
        }

        System.out.println("\nCashier processing payment:");
        ((Cashier)cashier).processPayment(cinnamonBuns);
    }
}
