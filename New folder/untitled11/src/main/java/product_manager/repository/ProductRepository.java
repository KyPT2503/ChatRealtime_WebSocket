package product_manager.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import product_manager.model.Category;
import product_manager.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);

    List<Product> findTop5ByOrderByDateDesc();

    List<Product> findTop5ByOrderByPriceDesc();

    List<Product> findTopByOrderByDateDesc(Pageable pageable);

    List<Product> findTopByOrderByPriceDesc(Pageable pageable);

    @Query("select sum(price*quantity) from Product")
    double totalMoney();
}
