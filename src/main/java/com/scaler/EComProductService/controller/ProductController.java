package com.scaler.EComProductService.controller;

import com.scaler.EComProductService.dto.ProductListResponseDTO;
import com.scaler.EComProductService.dto.ProductRequestDTO;
import com.scaler.EComProductService.dto.ProductResponseDTO;
import com.scaler.EComProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

//    Code to create products for get call - REST API Class 2
    /*
    @GetMapping("/products")
    public ResponseEntity getAllProducts(){

        ProductResponseDTO p1 = new ProductResponseDTO();
        p1.setId(1);
        p1.setTitle("Iphone");
        p1.setPrice(150000);
        p1.setImage("https://www.apple.com/v/iphone/home/by/images/meta/iphone__kqge21l9n26q_og.png");
        p1.setDescription("Iphone 15 pro max");
        p1.setCategory("Electronics");

        ProductResponseDTO p2 = new ProductResponseDTO();
        p2.setId(1);
        p2.setTitle("MacBook");
        p2.setPrice(250000);
        p2.setImage("https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/macbookair-og-202402?wid=600&hei=315&fmt=jpeg&qlt=95&.v=1707414684423");
        p2.setDescription("MacBook latest Version");
        p2.setCategory("Electronics");

//        ArrayList<ProductResponseDTO> products = new ArrayList<ProductResponseDTO>();
//        products.add(p1);
//        products.add(p2);

        List<ProductResponseDTO> products = Arrays.asList(p1,p2);


        return ResponseEntity.ok(products);
     */

//   Code to Get Product Using Id - FakeStoreAPI - REST API 2
    /*
    @Autowired
    @Qualifier("FakeStoreProductService")
    private ProductService productService;

    @GetMapping("products/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id){
        ProductResponseDTO response = productService.getProductById(id);
        return ResponseEntity.ok(response);
    }
    */

    private final ProductService productService;

    @Autowired
    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductFromId(@PathVariable("id") int id){
        ProductResponseDTO productResponseDTO = productService.getProductById(id);
        return ResponseEntity.ok(productResponseDTO);
    }

    @GetMapping("/products")
    public ResponseEntity getAllProducts(){
        ProductListResponseDTO productListResponseDTO = productService.getAllProducts();
        return ResponseEntity.ok(productListResponseDTO);
    }


    @PostMapping("/products")
    public ResponseEntity addNewProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO productResponseDTO = productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(productResponseDTO);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProductById(@PathVariable("id") int id){
        boolean productResponseDTO = productService.deleteProduct(id);
        return ResponseEntity.ok("Abdus");
    }

    @PutMapping("/products/{id}")
    public ResponseEntity updateByProductId(@PathVariable int id, @RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO productResponseDTO = productService.updateProduct(id, productRequestDTO);
        return ResponseEntity.ok(productResponseDTO);
    }
















}
