package com.microorder.productservice.productmanager;

import com.microorder.productservice.productmanager.dto.ProductRequest;

import lombok.experimental.UtilityClass;

@UtilityClass
class ProductMapper
{
    ProductEntity mapToEntity(ProductRequest productRequest)
    {
        return ProductEntity.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
    }
}