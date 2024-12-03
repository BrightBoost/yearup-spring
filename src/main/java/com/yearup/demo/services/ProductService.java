package com.yearup.demo.services;

import com.yearup.demo.models.Product;
import com.yearup.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // get a product by id
    public Product getProductById(long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        return null;
    }

    // deleting a product
    public void deleteProductById(long id) {
        Product product = getProductById(id);
        if(product != null) {
            productRepository.delete(product);
        }
    }

    // updating a product
    public void updateProduct(Product product, long id) {
        Product productToBeUpdated = getProductById(id);
        productToBeUpdated.setDescription(product.getDescription());
        productToBeUpdated.setName(product.getName());
        productToBeUpdated.setPrice(product.getPrice());
        productRepository.save(productToBeUpdated);
    }

    // adding a product
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
