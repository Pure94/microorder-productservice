package com.microorder.productservice.productmanager;

import com.microorder.productservice.productmanager.dto.ProductRequest;
import com.microorder.productservice.productmanager.dto.ProductResponse;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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
    String createProduct(@RequestBody ProductRequest product)
    {
        return productManager.createProduct(product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ProductResponse> getProducts()
    {
        return productManager.getProducts();
    }
}