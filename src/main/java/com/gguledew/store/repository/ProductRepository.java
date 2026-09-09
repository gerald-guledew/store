package com.gguledew.store.repository;

import com.gguledew.store.domain.Category;
import com.gguledew.store.domain.Product;
import com.gguledew.store.dtos.ProductSummary;
import com.gguledew.store.dtos.ProductSummaryDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
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
    @Modifying
    @Query("update Product p Set p.price = :newPrice where p.category.id = :categoryId")
    void updatePriceByCategory(@Param("newPrice") BigDecimal newPrice, @Param("categoryId") Byte categoryId);
    List<Product> findByCategory(Category category);
    @Query("select p.id as id from Product p where p.category = :category")
    List<ProductSummary> findProductSummaryByCategory(@Param("category") Category category);
    @Procedure("findProductByPrice")
    List<Product> findProductByPrice(BigDecimal min, BigDecimal max);
}