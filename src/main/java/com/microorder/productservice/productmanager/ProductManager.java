package com.microorder.productservice.productmanager;

import com.microorder.productservice.productmanager.dto.ProductRequest;
import com.microorder.productservice.productmanager.dto.ProductResponse;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
class ProductManager implements ProductManagerFacade
{
    private final ProductRepository productRepository;

    @Override
    public String createProduct(final ProductRequest product)
    {
        final ProductEntity productEntity = ProductMapper.mapToEntity(product);
        productRepository.save(productEntity);
        log.debug("Created product with id: {}", productEntity.getId());
        return productEntity.getId();
    }

    @Override
    public List<ProductResponse> getProducts()
    {
        return productRepository.findAll().stream()
                .map(ProductMapper::mapToResponse)
                .toList();
    }

}