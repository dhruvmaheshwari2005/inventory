package com.inventorypro.inventory.model;

import jakarta.persistence.*;

import javax.naming.Name;

/**
 * @description Model for Product table
 * @author Sushil Jangid
 * @version 1.0
 */
@Entity
public class Product {
    public long getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductStock() {
        return productStock;
    }

    public void setProductStock(Double productStock) {
        this.productStock = productStock;
    }

    public Product() {}

    public Product(int productId, String productName, Double productStock, Double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productStock = productStock;
        this.unitPrice = unitPrice;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productStock=" + productStock +
                ", unitPrice=" + unitPrice +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ")
    private long productId;

    private String productName;
    private Double productStock;
    private Double unitPrice;
}
