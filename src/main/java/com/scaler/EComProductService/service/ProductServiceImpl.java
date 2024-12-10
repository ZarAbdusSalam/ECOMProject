package com.scaler.EComProductService.service;

import com.scaler.EComProductService.dto.ProductResponseDTO;
import com.scaler.EComProductService.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
public class ProductServiceImpl implements ProductService{
    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(int id) {
        return null;
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        return null;
    }
}
