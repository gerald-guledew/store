package com.gguledew.store.controllers;

import com.gguledew.store.dtos.ProductDto;
import com.gguledew.store.mappers.ProductMapper;
import com.gguledew.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(productMapper::toDto).toList();
    }
}
