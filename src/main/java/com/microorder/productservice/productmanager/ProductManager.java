package com.microorder.productservice.productmanager;

import com.microorder.productservice.productmanager.dto.ProductRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
class ProductManager implements ProductManagerFacade
{
    private final ProductRepository productRepository;

    @Override
    public Long createProduct(final ProductRequest product)
    {
        final ProductEntity productEntity = ProductMapper.mapToEntity(product);
        productRepository.save(productEntity);
        log.debug("Created product with id: {}", productEntity.getId());
        return productEntity.getId();
    }
}