package Lab0;

public class Bakery {
    private String name;
    private EmployeeManager employeeManager;
    private BakeryInventory inventory;

    public Bakery(String name, EmployeeManager employeeManager, BakeryInventory inventory) {
        this.name = name;
        this.employeeManager = employeeManager;
        this.inventory = inventory;
    }

    public String getName() { return name; }
    public EmployeeManager getEmployeeManager() { return employeeManager; }
    public BakeryInventory getInventory() { return inventory; }
}
