package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    boolean remove(int id);

    boolean add(Product product);

    boolean update(int id, Product product);

    List<Product> findByName(String name);
}
