package com.myapp.graphql.service;

import com.myapp.graphql.entity.Product;
import com.myapp.graphql.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl {

    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProducts(String category) {
        return productRepository.findByCategory(category);
    }

    public Product updateStock(int id, int stock) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found"));
        product.setStock(stock);
        return productRepository.save(product);
    }

    public Product receivedNewShipment(int id, int quantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found"));
        product.setStock(product.getStock() + quantity);
        return productRepository.save(product);
    }
}
