package com.gguledew.store.service;

import com.gguledew.store.domain.Category;
import com.gguledew.store.domain.Product;
import com.gguledew.store.repository.CategoryRepository;
import com.gguledew.store.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class CatalogService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void addProduct() {
        var product = Product.builder().name("productname3").description("pdescription3").price(BigDecimal.valueOf(3)).build();
        var category = Category.builder().name("categoryname3").build();
        product.addCategory(category);
        productRepository.save(product);
        product = Product.builder().name("productname4").description("pdescription4").price(BigDecimal.valueOf(4)).build();
        product.addCategory(category);
        productRepository.save(product);
        product = Product.builder().name("pname3").description("pdesc3").price(BigDecimal.valueOf(3)).build();
        category = Category.builder().name("catname4").build();
        product.addCategory(category);
        productRepository.save(product);
        product = Product.builder().name("pname4").description("pdesc4").price(BigDecimal.valueOf(4)).build();
        product.addCategory(category);
        productRepository.save(product);
    }

    public void addProductToAExistingCategory() {
        var category = categoryRepository.findById((byte)1).get();
        var product = Product.builder().name("productname5").description("pdescription5").price(BigDecimal.valueOf(5)).build();
        product.addCategory(category);
        productRepository.save(product);
    }
}
