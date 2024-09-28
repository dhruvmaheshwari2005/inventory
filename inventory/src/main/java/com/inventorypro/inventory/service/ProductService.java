package com.inventorypro.inventory.service;

import com.inventorypro.inventory.controller.ProductController;
import com.inventorypro.inventory.model.Product;
import com.inventorypro.inventory.repo.ProductRepo;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private ProductController.ProductResponse getProductById(int productId) {
        ProductController.ProductResponse response = new ProductController.ProductResponse();

        List<Integer> productIds = new ArrayList<>();
        productIds.add(productId);

        List<Product> products = repo.findAllById(productIds);
        response.success = true;
        response.message = products.isEmpty() ? "No Products found" : "Products found";
        response.count = products.size();
        response.products = products;

        return response;
    }

    public ProductController.ProductResponse getProduct(String searchKeyword) {
        if (NumberUtils.isParsable(searchKeyword)) {
            return getProductById(Integer.parseInt(searchKeyword));
        } else {
            return getProductByName(searchKeyword);
        }
    }


    private ProductController.ProductResponse getProductByName(String searchKeyword) {
        ProductController.ProductResponse response = new ProductController.ProductResponse();

        List<Product> products = repo.findAll().stream()
                .filter(product -> product.getProductName().toLowerCase().contains(searchKeyword.toLowerCase()))
                .collect(Collectors.toList());
        

        System.out.println(products);

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
