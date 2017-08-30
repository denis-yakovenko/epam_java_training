package task6;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public Bank(String name) {
        this.name = name;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
