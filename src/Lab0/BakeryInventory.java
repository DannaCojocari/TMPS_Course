package Lab0;

import java.util.ArrayList;
import java.util.List;

class BakeryInventory {
    private List<IProduct> products = new ArrayList<>();

    public void addProduct(IProduct product) {
        if (product != null) products.add(product);
    }

    public List<IProduct> getProducts() {
        return new ArrayList<>(products);
    }
}