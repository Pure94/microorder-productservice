package com.microorder.productservice.productmanager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration (proxyBeanMethods = false)
class ProductManagerConfiguration
{
    @Bean
    ProductManagerFacade productManagerFacade(ProductRepository productRepository)
    {
        return new ProductManager(productRepository);
    }
}
