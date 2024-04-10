package com.example.Pensement.domain.dtos.product;

import com.example.Pensement.entities.Product;

public record ProductResponseDTO(String id, String name, Integer price) {
    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getPrice());
    }
}
