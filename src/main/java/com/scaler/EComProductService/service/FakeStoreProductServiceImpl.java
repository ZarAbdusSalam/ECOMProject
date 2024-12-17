package com.scaler.EComProductService.service;

import com.scaler.EComProductService.dto.ProductListResponseDTO;
import com.scaler.EComProductService.dto.ProductRequestDTO;
import com.scaler.EComProductService.dto.ProductResponseDTO;
import com.scaler.EComProductService.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("FakeStoreProductService")
public class FakeStoreProductServiceImpl implements  ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        String getAllProductsURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate =restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO[]> productResponseArray = restTemplate.getForEntity(getAllProductsURL,ProductResponseDTO[].class);
//        System.out.println(restTemplate);
//        System.out.println(productResponseArray);
//        System.out.println(restTemplate.toString());
//        System.out.println(productResponseArray.toString());
//        System.out.println(productResponseArray.getBody());
//        System.out.println(productResponseArray.getHeaders());
//        System.out.println(productResponseArray.getClass());
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();

        for(ProductResponseDTO productResponseDTO: productResponseArray.getBody()){
            productListResponseDTO.getProductResponseDTOList().add(productResponseDTO);
//            System.out.println(productResponseDTO.getId());
//            System.out.println(productResponseDTO.getTitle());
        }

//        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
//        for (String i : cars) {
//            System.out.println(i);
//        }
        return productListResponseDTO;
    }

    @Override
    public ProductResponseDTO getProductById(int id) {

        String getProductByIdURL = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse = restTemplate.getForEntity(getProductByIdURL,ProductResponseDTO.class);
        System.out.println(productResponse.getBody());
        return productResponse.getBody();
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {

        String addNewProductURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse = restTemplate.postForEntity(addNewProductURL,productRequestDTO,ProductResponseDTO.class);
        System.out.println(productResponse.getBody().getTitle());
        return productResponse.getBody();
    }

    @Override
    public boolean deleteProduct(int id) {

        String deleteProductByIdURL = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteProductByIdURL);
        return true;
    }

    @Override
    public ProductResponseDTO updateProduct(int id, ProductRequestDTO updatedProduct) {
        String updateProductByIdURL = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
//        restTemplate.put(updateProductByIdURL, updatedProduct);
        ProductResponseDTO productResponse = restTemplate.patchForObject(updateProductByIdURL,updatedProduct,ProductResponseDTO.class);
        return productResponse;
    }
}
