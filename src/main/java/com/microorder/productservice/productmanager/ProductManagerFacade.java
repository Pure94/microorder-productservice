package com.microorder.productservice.productmanager;

import com.microorder.productservice.productmanager.dto.ProductRequest;

public interface ProductManagerFacade
{
    Long createProduct(ProductRequest product);
}
