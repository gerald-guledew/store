package com.gguledew.store.repository;

import com.gguledew.store.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductCriteriaRepository {
    List<Product> findProductsByCriteria(String name, BigDecimal minPrice, BigDecimal maxPrice, Byte categoryId);
}
