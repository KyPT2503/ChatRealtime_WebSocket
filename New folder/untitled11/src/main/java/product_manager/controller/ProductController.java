package product_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import product_manager.model.Category;
import product_manager.model.Product;
import product_manager.service.category.ICategoryService;
import product_manager.service.product.IProductService;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;

    @ModelAttribute("categories")
    public List<Category> getAllCategory() {
        return categoryService.findAll();
    }

    @ModelAttribute("total_money")
    public double getTotalMoney() {
        return productService.totalMoney();
    }

    @GetMapping("create")
    public ModelAndView showCreatePage() {
        return new ModelAndView("product/create", "product", new Product());
    }

    /*@PostMapping("create-product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        productService.add(product);
        return new ResponseEntity<>(productService.findById(product.getId()), HttpStatus.CREATED);
    }*/
    @PostMapping("create-product")
    public Product createProduct(@RequestBody Product product) {
        productService.add(product);
        return product;
    }

    @GetMapping("/all")
    public ModelAndView all() {
        ModelAndView modelAttribute = new ModelAndView("product/index");
        modelAttribute.addObject("products", productService.findAll());
        return modelAttribute;
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdatePage(@PathVariable("id") Product product) {
        return new ModelAndView("product/index", "product", product);
    }

    @PostMapping("/update-product")
    public ModelAndView update(@ModelAttribute("product") Product product) {
        productService.update(product.getId(), product);
        return new ModelAndView("redirect:/product/all");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView showDetailPage(@PathVariable("id") Product product) {
        return new ModelAndView("product/remove", "product", product);
    }

    @DeleteMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        Product product = productService.findById(id);
        productService.remove(product.getId());
        return "Removed product, id:" + product.getId() + ", name:" + product.getName();
    }

    @PostMapping("/category-search")
    public ModelAndView searchByCategory(@ModelAttribute("id") Category category) {
        return new ModelAndView("product/index", "products", productService.findByCategory(category));
    }

    @GetMapping("/top5newest")
    public ModelAndView top5Newest() {
        return new ModelAndView("product/index", "products", productService.find5Newest());
    }

    @GetMapping("top5much-expensive")
    public ModelAndView top5MuchExpensive() {
        return new ModelAndView("product/index", "products", productService.find5MuchExpensive());
    }

    @GetMapping("/message")
    public String getMessage() {
        return "this is message from server to test ajax!!!";
    }
}
