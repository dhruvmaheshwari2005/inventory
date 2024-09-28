package com.inventorypro.inventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="supplier")
public class Supplier {
    @Id
    @Column(name="supplier_id")
    private long supplierId;
    private String address;


}
