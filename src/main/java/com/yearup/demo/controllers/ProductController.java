package com.yearup.demo.controllers;

import com.yearup.demo.models.Product;
import com.yearup.demo.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // get all
    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    // get by id
    @GetMapping("{id}")
    public Product getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    // post
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // put
    @PutMapping("{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable long id) {
        productService.updateProduct(product, id);
    }

    // delete
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable long id) {
        productService.deleteProductById(id);
    }
}
