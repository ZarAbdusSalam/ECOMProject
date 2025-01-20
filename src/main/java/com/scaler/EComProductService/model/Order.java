package com.scaler.EComProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Entity (name = "ECOM_Order")
@Data
public class Order extends BaseModel{

    @ManyToMany
    private List<Product> productList;
}
