package com.learn.fakeshop.fakeshop.controller;

import com.learn.fakeshop.fakeshop.dto.ProductDto;
import com.learn.fakeshop.fakeshop.model.Product;
import com.learn.fakeshop.fakeshop.repository.FakeShopRepository;
import com.learn.fakeshop.fakeshop.service.FakeShopService;
import com.learn.fakeshop.fakeshop.service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class RestClientController {
    @Autowired
    private RestClientService restClientService;

    @Autowired
    private FakeShopRepository fakeShopRepository;

    @Autowired
    private FakeShopService fakeShopService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> findProducts() throws IOException {
        ResponseEntity<List<ProductDto>> products = restClientService.getProducts();
        Product product = new Product();
        for(ProductDto pro : products.getBody()){
            product.setId(pro.getId());
            product.setTitle(pro.getTitle());
            product.setPrice(pro.getPrice());
            product.setDescription(pro.getDescription());
            product.setImage(pro.getImage());
            product.setCategory(pro.getCategory());
            fakeShopRepository.save(product);
        }
        return products;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findProducts(@PathVariable("id") int id) throws IOException {
        ResponseEntity<ProductDto> products = restClientService.getProducts(id);
        return products;
    }

}
