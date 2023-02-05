package com.microorder.productservice.productmanager.dto;

import jakarta.validation.constraints.NotBlank;

public record ProductRequest(@NotBlank String name,
                      String description,
                      String price)
{
}
