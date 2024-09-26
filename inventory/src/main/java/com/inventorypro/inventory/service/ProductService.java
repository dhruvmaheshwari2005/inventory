package com.inventorypro.inventory.service;

import com.inventorypro.inventory.controller.ProductController;
import com.inventorypro.inventory.model.Product;
import com.inventorypro.inventory.repo.ProductRepo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class ProductService {
    ProductRepo repo;

    public ProductService(ProductRepo repo) {
        this.repo = repo;
    }

    public ProductController.ProductResponse getProducts() {
        ProductController.ProductResponse response = new ProductController.ProductResponse();
        List<Product> products = repo.findAll();
        response.success = true;
        response.message = products.isEmpty() ? "No Products found" : "Products found";
        response.count = products.size();
        response.products = products;

        return response;
    }

    public ProductController.ProductResponse createProducts(List<Product> products) {
        ProductController.ProductResponse response = new ProductController.ProductResponse();
        List<Product> createdProducts = repo.saveAll(products);

        response.success = true;
        response.message = createdProducts.size() == products.size() ?
                "All products inserted" :
                "Error in inserting some products";
        response.count = createdProducts.size();
        response.products = createdProducts;

        return response;
    }
}
