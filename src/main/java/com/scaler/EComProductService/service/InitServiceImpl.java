package com.scaler.EComProductService.service;

import com.scaler.EComProductService.model.Category;
import com.scaler.EComProductService.model.Order;
import com.scaler.EComProductService.model.Price;
import com.scaler.EComProductService.model.Product;
import com.scaler.EComProductService.repository.CategoryRepository;
import com.scaler.EComProductService.repository.OrderRepository;
import com.scaler.EComProductService.repository.PriceRepository;
import com.scaler.EComProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitServiceImpl implements InitService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private PriceRepository priceRepository;
    private OrderRepository orderRepository;

    public InitServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, PriceRepository priceRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void initialise() {

//      Add Category
        Category electronics = new Category();
        electronics.setCategoryName("Electronics");
        electronics = categoryRepository.save(electronics);

//        Add 3 products to Category and set their prices

        Price macBookPrice = new Price();
        macBookPrice.setAmount(2_00_000.00);
        macBookPrice.setCurrency("INR");
        macBookPrice.setDiscount(5.00);
        macBookPrice = priceRepository.save(macBookPrice);

        Price iPhonePrice = new Price();
        iPhonePrice.setAmount(1_00_000.00);
        iPhonePrice.setCurrency("INR");
        iPhonePrice.setDiscount(5.00);
        iPhonePrice = priceRepository.save(iPhonePrice);

        Price iWatchPrice = new Price();
        iWatchPrice.setAmount(50_000.00);
        iWatchPrice.setCurrency("INR");
        iWatchPrice.setDiscount(5.00);
        iWatchPrice = priceRepository.save(iWatchPrice);

        Product macBook = new Product();
        macBook.setTitle("Mac Book");
        macBook.setDescription("Best Mac Book");
        macBook.setImage("macBookImage");
        macBook.setPrice(macBookPrice);
        macBook.setCategory(electronics);
        macBook = productRepository.save(macBook);

        Product iPhone = new Product();
        iPhone.setTitle("iPhone");
        iPhone.setDescription("Best iPhone");
        iPhone.setImage("iPhoneImage");
        iPhone.setPrice(iPhonePrice);
        iPhone.setCategory(electronics);
        iPhone = productRepository.save(iPhone);

        Product iWatch = new Product();
        iWatch.setTitle("iWatch");
        iWatch.setDescription("Best iWatch");
        iWatch.setImage("iWatchImage");
        iWatch.setPrice(iWatchPrice);
        iWatch.setCategory(electronics);
        iWatch = productRepository.save(iWatch);

//        Place order with these 3 products

        Order order = new Order();
        order.setProductList(List.of(iPhone, iWatch, macBook));
        order = orderRepository.save(order);

    }
}
