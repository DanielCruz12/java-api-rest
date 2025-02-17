package com.example.api_rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.api_rest.repositories.ProductRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.api_rest.entities.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product createNewProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@RequestParam Long id) {
        Product newProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el Id: " + id));
        return newProduct;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product newProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el Id: " + id));
        newProduct.setName(product.getName());
        return productRepository.save(newProduct);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@RequestParam Long id) {
        Product productdeleted = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el Id: " + id));
        productRepository.delete(productdeleted);
        return productdeleted;
    }

}
