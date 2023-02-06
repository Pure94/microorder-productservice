package com.microorder.productservice.productmanager;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private String id;
    private String name;
    private String description;
    private Double price;
}