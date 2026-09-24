package com.gguledew.store.mappers;

import com.gguledew.store.dtos.ProductDto;
import com.gguledew.store.entities.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Product product);
    @Mapping(target="category", ignore = true)
    Product toEntity(ProductDto request);
    @Mapping(target="id", ignore=true)
    @Mapping(target="category", ignore=true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProduct(ProductDto request, @MappingTarget Product product);
}
