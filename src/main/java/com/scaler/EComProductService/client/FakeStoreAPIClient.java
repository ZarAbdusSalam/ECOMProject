package com.scaler.EComProductService.client;

import com.scaler.EComProductService.dto.FakeStoreProductRequestDTO;
import com.scaler.EComProductService.dto.FakeStoreProductResponseDTO;
import com.scaler.EComProductService.dto.ProductRequestDTO;
import com.scaler.EComProductService.dto.ProductResponseDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreAPIClient {

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
        String addNewProductURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.postForEntity(addNewProductURL,fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
//        System.out.println(productResponse.getBody().getTitle());
        return productResponse.getBody();
    }

    public FakeStoreProductResponseDTO getProductById(int id) {
        String getProductByIdURL = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.getForEntity(getProductByIdURL,FakeStoreProductResponseDTO.class);
        System.out.println(productResponse.getBody());
        return productResponse.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String getAllProductsURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseArray = restTemplate.getForEntity(getAllProductsURL,FakeStoreProductResponseDTO[].class);
        return List.of(productResponseArray.getBody());
    }
}
