package com.trufin.graphql.service;

import com.trufin.graphql.entity.Product;
import com.trufin.graphql.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public List<Product> getProducts() {
       return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Product updateStock(int id, int stock) {
        Product product = productRepository.findById(id).orElseThrow((

        ) -> new RuntimeException("Product not found with id " + id));
        product.setStock(stock);
        return productRepository.save(product);

    }

    public Product receiveNewShipment(int id, int quantity) {
        Product product = productRepository.findById(id).orElseThrow((

        ) -> new RuntimeException("Product not found with id " + id));
        product.setStock(product.getStock() +quantity);
        return productRepository.save(product);

    }
}
