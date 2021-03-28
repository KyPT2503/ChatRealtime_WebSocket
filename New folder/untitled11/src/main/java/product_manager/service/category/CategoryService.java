package product_manager.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product_manager.model.Category;
import product_manager.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean remove(Long id) {
        categoryRepository.delete(id);
        return true;
    }

    @Override
    public Category add(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long id, Category category) {
        return null;
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findOne(id);
    }
}
