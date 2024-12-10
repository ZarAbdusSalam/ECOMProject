package com.scaler.EComProductService.service;

import com.scaler.EComProductService.dto.ProductResponseDTO;
import com.scaler.EComProductService.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    ProductResponseDTO getProductById(int id);
    Product createProduct(Product product);
    Product deleteProduct(int id);
    Product updateProduct(int id, Product updatedProduct);
}
