package com.microorder.productservice.productmanager;

import com.microorder.productservice.productmanager.dto.ProductRequest;
import com.microorder.productservice.productmanager.dto.ProductResponse;
import java.util.List;

public interface ProductManagerFacade
{
    String createProduct(ProductRequest product);

    List<ProductResponse> getProducts();
}
