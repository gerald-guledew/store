package com.gguledew.store.controllers;

import com.gguledew.store.dtos.ProductDto;
import com.gguledew.store.entities.Product;
import com.gguledew.store.mappers.ProductMapper;
import com.gguledew.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> getProducts(@RequestParam(required = false, name = "categoryId") Byte categoryId) {
        List<Product> product;
        if (categoryId == null) {
            product = productRepository.findAllWithCategory();
        } else {
            product = productRepository.findByCategoryId(categoryId);
        }

        return product.stream().map(productMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        var product = productRepository.findById(id).orElse(null);
        if (product != null) {
            return ResponseEntity.ok(productMapper.toDto(product));
        }
        return ResponseEntity.notFound().build();
    }
}
