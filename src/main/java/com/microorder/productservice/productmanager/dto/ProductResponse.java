package com.microorder.productservice.productmanager.dto;

import lombok.Builder;

@Builder
public record ProductResponse(String name, String description, Double price)
{ }
