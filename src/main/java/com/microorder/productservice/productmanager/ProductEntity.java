package com.microorder.productservice.productmanager;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(value = "products")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class ProductEntity
{
    @Id
    private Long id;
    private String name;
    private String description;
    private String price;
}