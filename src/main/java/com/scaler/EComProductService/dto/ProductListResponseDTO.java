package com.scaler.EComProductService.dto;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Accessors(chain = true)
public class ProductListResponseDTO {

    private List<ProductResponseDTO> productResponseDTOList;

//    public ProductListResponseDTO(List<ProductResponseDTO> productResponseDTOList) {
//        this.productResponseDTOList = productResponseDTOList;
//    }


    public ProductListResponseDTO() {
        this.productResponseDTOList = new ArrayList<>();
    }
}
