package com.scaler.EComProductService.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity (name = "ECOM_Price")
@Data
public class Price extends BaseModel{
    private String currency;
    private double amount;
    private double discount;

}
