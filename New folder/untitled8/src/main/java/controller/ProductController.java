package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.IProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/all")
    public ModelAndView showIndexPage() {
        return new ModelAndView("index", "products", productService.getAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreatePate() {
        return new ModelAndView("create", "product", new Product());
    }

    @PostMapping("/create")
    public ModelAndView create(Product product) {
        product.setId(productService.getAll().size());
        productService.add(product);
        return new ModelAndView("redirect:/products/all");
    }
}
