package com.scaler.EComProductService.model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ECOM_Product")
public class Product extends BaseModel{

//    private int id;
    private String title;
    @OneToOne
    private Price price;
    @ManyToOne
    private Category category;
    private String description;
    private String image;
}
