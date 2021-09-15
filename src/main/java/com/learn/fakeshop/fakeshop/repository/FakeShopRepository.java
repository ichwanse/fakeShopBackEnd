package com.learn.fakeshop.fakeshop.repository;

import com.learn.fakeshop.fakeshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FakeShopRepository extends JpaRepository<Product,Long> {
}
