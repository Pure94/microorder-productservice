package com.microorder.productservice.productmanager;

import com.microorder.productservice.productmanager.dto.ProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
class ProductManagerController
{
    private final ProductManagerFacade productManager;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Long createProduct(@RequestBody ProductRequest product)
    {
        return productManager.createProduct(product);
    }

}