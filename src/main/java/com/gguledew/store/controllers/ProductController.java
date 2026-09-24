package com.gguledew.store.controllers;

import com.gguledew.store.dtos.ProductDto;
import com.gguledew.store.entities.Product;
import com.gguledew.store.mappers.ProductMapper;
import com.gguledew.store.repositories.CategoryRepository;
import com.gguledew.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private ProductRepository productRepository;
    private ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

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

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(
            @RequestBody ProductDto request,
            UriComponentsBuilder uriBuilder) {
        var product = productMapper.toEntity(request);
        var category = categoryRepository.getReferenceById(request.getCategoryId());
        product.setCategory(category);
        productRepository.save(product);
        var productDto = productMapper.toDto(product);
        var uri = uriBuilder.path("/products/{id}").buildAndExpand(productDto.getId()).toUri();
        return ResponseEntity.created(uri).body(productDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDto request){
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        productMapper.updateProduct(request, product);
        if (request.getCategoryId() != null) {
            var category = categoryRepository.getReferenceById(request.getCategoryId());
            product.setCategory(category);
        }
        productRepository.save(product);
        return ResponseEntity.ok(productMapper.toDto(product));
    }


}
