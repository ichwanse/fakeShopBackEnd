package com.learn.fakeshop.fakeshop.service;

import com.learn.fakeshop.fakeshop.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RestClientService {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<ProductDto> getProducts(int id){
        ProductDto result = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, ProductDto.class);
//        ProductDto[] result = restTemplate.getForObject("https://fakestoreapi.com/products", ProductDto[].class);
//        System.out.println(Arrays.toString(result));
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<List<ProductDto>> getProducts(){
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        ProductDto[] productDtos = restTemplate.getForObject("https://fakestoreapi.com/products/", ProductDto[].class);
//        ProductDto[] result = restTemplate.getForObject("https://fakestoreapi.com/products", ProductDto[].class);
//        System.out.println(Arrays.toString(result));
//        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<List<ProductDto>> result = restTemplate.exchange("https://fakestoreapi.com/products", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return ResponseEntity.ok(result.getBody());
    }
}
