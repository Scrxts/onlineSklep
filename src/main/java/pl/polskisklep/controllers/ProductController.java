package pl.polskisklep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.polskisklep.model.Product;
import pl.polskisklep.repository.ProductRepository;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/product")
    public String productView(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("productList", products);
        return "product";
    }

    @GetMapping("/addProduct")
    public String addProductView(Model model) {
        model.addAttribute("product",new Product());
        return "addProduct";
    }



    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productRepository.save(product);
        return "redirect:/products/product";
    }

}
