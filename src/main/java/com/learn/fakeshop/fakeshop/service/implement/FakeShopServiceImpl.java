package com.learn.fakeshop.fakeshop.service.implement;

import com.learn.fakeshop.fakeshop.model.Product;
import com.learn.fakeshop.fakeshop.repository.FakeShopRepository;
import com.learn.fakeshop.fakeshop.service.FakeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FakeShopServiceImpl implements FakeShopService {
    @Autowired
    private FakeShopRepository fakeShopRepository;

    @Override
    public List<Product> getProducts() {
        return fakeShopRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return fakeShopRepository.findById(id);
    }

    @Override
    public void createProduct(Product product) {
        fakeShopRepository.save(product);
    }
}
