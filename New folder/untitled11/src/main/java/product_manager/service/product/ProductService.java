package product_manager.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import product_manager.model.Category;
import product_manager.model.Product;
import product_manager.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean remove(Long id) {
        productRepository.delete(id);
        return true;
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> find5Newest() {
        return productRepository.findTop5ByOrderByDateDesc();
    }

    @Override
    public List<Product> find5MuchExpensive() {
        return productRepository.findTop5ByOrderByPriceDesc();
    }

    @Override
    public double totalMoney() {
        return productRepository.totalMoney();
    }
}
