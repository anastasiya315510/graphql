package com.trufin.graphql.controller;

import com.trufin.graphql.entity.Product;
import com.trufin.graphql.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @QueryMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }
    @QueryMapping
    public List<Product> getProductsByCategory(@Argument String category) {
        return productService.getProductsByCategory(category);
    }

    @MutationMapping
    public Product updateProduct(@Argument int id, @Argument int stock ) {
        return productService.updateStock(id, stock);
    }


    @MutationMapping
    public Product receiveNewShipment(@Argument int id, @Argument int quantity) {
        return productService.receiveNewShipment(id, quantity);
    }
}
