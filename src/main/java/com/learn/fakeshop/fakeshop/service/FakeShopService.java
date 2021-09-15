package com.learn.fakeshop.fakeshop.service;

import com.learn.fakeshop.fakeshop.model.Product;

import java.util.List;
import java.util.Optional;


public interface FakeShopService {
    List<Product> getProducts();

    Optional<Product> getProductById(Long id);

    void createProduct(Product product);
}
