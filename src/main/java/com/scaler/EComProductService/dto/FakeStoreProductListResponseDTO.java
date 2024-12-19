package com.scaler.EComProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class FakeStoreProductListResponseDTO {

    private List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOList;

//    public ProductListResponseDTO(List<ProductResponseDTO> productResponseDTOList) {
//        this.productResponseDTOList = productResponseDTOList;
//    }


    public FakeStoreProductListResponseDTO() {
        this.fakeStoreProductResponseDTOList = new ArrayList<>();
    }
}
