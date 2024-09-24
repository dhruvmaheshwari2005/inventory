package com.inventorypro.inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @description Model for Product table
 * @author Sushil Jangid
 * @version 1.0
 */
@Entity
public class Product {
    @Id
    public int productId;

    public String productName;
    public Double productStock;
    public Double unitPrice;
}
