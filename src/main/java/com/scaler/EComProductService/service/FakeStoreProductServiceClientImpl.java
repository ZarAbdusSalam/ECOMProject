package com.scaler.EComProductService.service;


import com.scaler.EComProductService.client.FakeStoreAPIClient;
import com.scaler.EComProductService.dto.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import static com.scaler.EComProductService.mapper.ProductMapper.productRequestToFakeStoreProductRequest;
import static com.scaler.EComProductService.mapper.ProductMapper.productResponseToFakeStoreProductResponse;
import static com.scaler.EComProductService.mapper.ProductMapper.fakeStoreProductRequestToProductRequest;
import static com.scaler.EComProductService.mapper.ProductMapper.fakeStoreProductResponseToProductResponse;

@Service("FakeStoreProductServiceClient")
public class FakeStoreProductServiceClientImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductServiceClientImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreAPIClient fakeStoreAPIClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        return null;
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        FakeStoreProductResponseDTO fakeStoreProductDTO = fakeStoreAPIClient.getProductById(id);
        return fakeStoreProductResponseToProductResponse(fakeStoreProductDTO);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = productRequestToFakeStoreProductRequest(productRequestDTO);
        FakeStoreProductResponseDTO fakeStoreProductDTO = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDTO);
        return fakeStoreProductResponseToProductResponse(fakeStoreProductDTO);
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public ProductResponseDTO updateProduct(int id, ProductRequestDTO updatedProduct) {
        return null;
    }
}
