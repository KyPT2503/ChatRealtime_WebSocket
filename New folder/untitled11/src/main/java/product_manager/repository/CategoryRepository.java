package product_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product_manager.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
