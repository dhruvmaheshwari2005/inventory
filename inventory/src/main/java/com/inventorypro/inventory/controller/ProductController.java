package com.inventorypro.inventory.controller;

import com.inventorypro.inventory.model.Product;
import com.inventorypro.inventory.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Welcome to Inventory Pro";
    }

    @GetMapping("/products")
    public ProductResponse getProducts() {
        return service.getProducts();
    }

    @GetMapping("/products/{searchKeyword}")
    public ProductResponse getProducts(@PathVariable String searchKeyword) {
        return service.getProduct(searchKeyword);
    }

    @PostMapping("/products")
    public ProductResponse createProducts(@RequestBody List<Product> products) {
        return service.createProducts(products);
    }

    /**
     * Product response wrapper for get product request
     */
    public static class ProductResponse {
        public boolean success;
        public List<Product> products;
        public String message;
        public int count;
    }
}
