package com.gguledew.store.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class ProductDto {
    private Long id;
    @NotBlank (message="Name is required")
    @Size (max = 255 , message = "Name must be less than 255 characters")
    private String name;
    private String description;
    private BigDecimal price;
    private Byte categoryId;
}
