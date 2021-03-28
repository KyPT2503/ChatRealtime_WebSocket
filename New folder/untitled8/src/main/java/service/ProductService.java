package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {

    private static Map<Integer, Product> products = new HashMap();

    static {
        products.put(0, new Product(0, 10, 10.5d, "Pen", "Thien Long"));
        products.put(1, new Product(1, 10, 10.5d, "Laptop", "Thien Long"));
        products.put(2, new Product(2, 10, 10.5d, "Book", "Thien Long"));
        products.put(3, new Product(3, 10, 10.5d, "Shoes", "Thien Long"));
        products.put(4, new Product(4, 10, 10.5d, "Guitar", "Thien Long"));
        products.put(5, new Product(5, 10, 10.5d, "Headphone", "Thien Long"));
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public boolean remove(int id) {
        products.remove(id);
        return true;
    }

    @Override
    public boolean add(Product product) {
        products.put(product.getId(), product);
        return true;
    }

    @Override
    public boolean update(int id, Product product) {
        products.replace(id, product);
        return true;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = this.getAll();
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(name)) {
                result.add(product);
            }
        }
        return result;
    }
}
