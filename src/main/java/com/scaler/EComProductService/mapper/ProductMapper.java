package com.scaler.EComProductService.mapper;

import com.scaler.EComProductService.dto.FakeStoreProductRequestDTO;
import com.scaler.EComProductService.dto.FakeStoreProductResponseDTO;
import com.scaler.EComProductService.dto.ProductRequestDTO;
import com.scaler.EComProductService.dto.ProductResponseDTO;

public class ProductMapper {

    public static FakeStoreProductRequestDTO productRequestToFakeStoreProductRequest(ProductRequestDTO productRequestDTO){

        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = new FakeStoreProductRequestDTO();
        fakeStoreProductRequestDTO.setCategory(productRequestDTO.getCategory());
        fakeStoreProductRequestDTO.setDescription(productRequestDTO.getDescription());
        fakeStoreProductRequestDTO.setTitle(productRequestDTO.getTitle());
        fakeStoreProductRequestDTO.setPrice(productRequestDTO.getPrice());
        fakeStoreProductRequestDTO.setImage(productRequestDTO.getImage());

        return fakeStoreProductRequestDTO;
    }

    public static FakeStoreProductResponseDTO productResponseToFakeStoreProductResponse(ProductResponseDTO productResponseDTO){

        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = new FakeStoreProductResponseDTO();
        fakeStoreProductResponseDTO.setId(productResponseDTO.getId());
        fakeStoreProductResponseDTO.setCategory(productResponseDTO.getCategory());
        fakeStoreProductResponseDTO.setDescription(productResponseDTO.getDescription());
        fakeStoreProductResponseDTO.setTitle(productResponseDTO.getTitle());
        fakeStoreProductResponseDTO.setPrice(productResponseDTO.getPrice());
        fakeStoreProductResponseDTO.setImage(productResponseDTO.getImage());

        return fakeStoreProductResponseDTO;
    }

    public static ProductRequestDTO fakeStoreProductRequestToProductRequest(FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setCategory(fakeStoreProductRequestDTO.getCategory());
        productRequestDTO.setDescription(fakeStoreProductRequestDTO.getDescription());
        productRequestDTO.setTitle(fakeStoreProductRequestDTO.getTitle());
        productRequestDTO.setPrice(fakeStoreProductRequestDTO.getPrice());
        productRequestDTO.setImage(fakeStoreProductRequestDTO.getImage());

        return productRequestDTO;
    }

    public static ProductResponseDTO fakeStoreProductResponseToProductResponse(FakeStoreProductResponseDTO fakeStoreProductResponseDTO){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(fakeStoreProductResponseDTO.getId());
        productResponseDTO.setCategory(fakeStoreProductResponseDTO.getCategory());
        productResponseDTO.setDescription(fakeStoreProductResponseDTO.getDescription());
        productResponseDTO.setTitle(fakeStoreProductResponseDTO.getTitle());
        productResponseDTO.setPrice(fakeStoreProductResponseDTO.getPrice());
        productResponseDTO.setImage(fakeStoreProductResponseDTO.getImage());

        return productResponseDTO;

    }
}
