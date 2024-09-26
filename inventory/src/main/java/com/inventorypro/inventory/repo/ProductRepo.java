package com.inventorypro.inventory.repo;

import com.inventorypro.inventory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
