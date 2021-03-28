package product_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import product_manager.model.Category;
import product_manager.service.category.ICategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        return new ModelAndView("category/create", "category", new Category());
    }

    @PostMapping("/create-category")
    public ModelAndView create(@ModelAttribute("category") Category category) {
        categoryService.add(category);
        return new ModelAndView("redirect:/category/create");
    }
}
