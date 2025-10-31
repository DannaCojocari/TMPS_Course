package Lab1;

import Lab1.FactoryMethod.*;
import Lab1.Singleton.*;
import Lab1.Builder.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuFactory menuFactory = null;

        OrderManager orderManager = OrderManager.getInstance();

        while (true) {
            System.out.println("\n\n==== Bakery ====");
            System.out.println("1. Sweets Menu");
            System.out.println("2. Beverages Menu");
            System.out.println("3. Build Cake / Cupcake");
            System.out.println("0. Exit");
            System.out.print("Choose menu: ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("0")) {
                System.out.println("Goodbye!");
                break;
            }

            switch (choice) {
                case "1":
                    menuFactory = new SweetsMenuFactory();
                    break;
                case "2":
                    menuFactory = new BeveragesMenuFactory();
                    break;
                case "3":
                    System.out.println("\n--- Builder Function ---");
                    Director director = new Director();

                    CakeBuilder cakeBuilder = new CakeBuilder();
                    CupcakeBuilder cupcakeBuilder = new CupcakeBuilder();

                    director.constructBirthdayTemplate(cakeBuilder);
                    Cake birthdayCake = cakeBuilder.getProduct();

                    director.constructBirthdayTemplate(cupcakeBuilder);
                    Cupcake birthdayCupcake = cupcakeBuilder.getProduct();

                    director.constructHalloweenTemplate(cakeBuilder);
                    Cake halloweenCake = cakeBuilder.getProduct();

                    System.out.println("\nProducts built using Builder:");
                    System.out.println(birthdayCake);
                    System.out.println(halloweenCake);
                    System.out.println(birthdayCupcake);
                    continue;
                default:
                    System.out.println("Invalid choice. Try again.\n");
                    continue;
            }

            IMenu menu = menuFactory.createMenu();
            menu.getMenu();

            Order order = new Order();

            List<IProduct> products = menu.getProducts();
            if (products == null || products.isEmpty()) {
                System.out.println("This menu has no products.");
                continue;
            }

            boolean addingItems = true;
            while (addingItems) {
                System.out.print("Select an item by number: ");
                String itemChoice = scanner.nextLine().trim();
                int itemIndex;
                try {
                    itemIndex = Integer.parseInt(itemChoice) - 1;
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid number. Try again.");
                    continue;
                }
                if (itemIndex < 0 || itemIndex >= products.size()) {
                    System.out.println("Choice out of range. Try again.");
                    continue;
                }

                IProduct selectedProduct = products.get(itemIndex);

                System.out.print("Quantity: ");
                String qtyStr = scanner.nextLine().trim();
                int qty;
                try {
                    qty = Integer.parseInt(qtyStr);
                    if (qty <= 0) throw new NumberFormatException();
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid quantity. Use a positive integer.");
                    continue;
                }

                order.addItem(selectedProduct, qty);
                System.out.println("Added: " + selectedProduct.getName() + " x" + qty);

                System.out.print("Add another item from this menu? (y/n): ");
                String more = scanner.nextLine().trim().toLowerCase();
                if (!more.equals("y") && !more.equals("yes")) {
                    addingItems = false;
                }
            }

            orderManager.addOrder(order);
            System.out.println("\nOrder summary:");
            order.getOrderDetails();

            System.out.print("\nDo you want to continue shopping? (y/n): ");
            String cont = scanner.nextLine().trim().toLowerCase();
            if (!cont.equals("y") && !cont.equals("yes")) {
                System.out.println("Thank you! Final orders:");
                orderManager.showOrders();
                break;
            }
        }
        scanner.close();
    }
}
