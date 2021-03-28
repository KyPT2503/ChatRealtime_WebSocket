package product_manager.service.product;

import product_manager.model.Category;
import product_manager.model.Product;
import product_manager.service.IGeneralService;

import java.util.List;

public interface IProductService extends IGeneralService<Product> {
    List<Product> findByCategory(Category category);

    List<Product> find5Newest();

    List<Product> find5MuchExpensive();

    double totalMoney();
}
