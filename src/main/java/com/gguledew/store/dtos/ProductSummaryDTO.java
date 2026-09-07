package com.gguledew.store.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductSummaryDTO {
    private Long id;
    private String name;

    public ProductSummaryDTO(Long id) {
        this.id = id;
    }
}
