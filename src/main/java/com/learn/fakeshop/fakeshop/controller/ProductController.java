package com.learn.fakeshop.fakeshop.controller;

import com.learn.fakeshop.fakeshop.model.Product;
import com.learn.fakeshop.fakeshop.service.FakeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private FakeShopService fakeShopService;

    @GetMapping
    public List<Product> getProduct(){
        return fakeShopService.getProducts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable("id") Long id){
        Optional<Product> result = fakeShopService.getProductById(id);
         return result.map(
                response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }

    @PostMapping(path="/products")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        fakeShopService.createProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
