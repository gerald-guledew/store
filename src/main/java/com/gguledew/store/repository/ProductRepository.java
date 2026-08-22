package com.gguledew.store.repository;

import com.gguledew.store.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);
    List<Product> findTop5ByNameOrderByPriceDesc(String name);
    List<Product> findByPriceBetweenOrderByNameAsc(BigDecimal minPrice, BigDecimal maxPrice);
    @Query(value = "select * from products p where p.price between :min and :max order by p.name", nativeQuery = true)
    List<Product> findByProduct(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

}