package com.gguledew.store.mappers;

import com.gguledew.store.dtos.ProductDto;
import com.gguledew.store.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);
}
