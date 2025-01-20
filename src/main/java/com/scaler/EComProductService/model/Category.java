package com.scaler.EComProductService.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ECOM_Category")
public class Category extends BaseModel{

    private String categoryName;
}
