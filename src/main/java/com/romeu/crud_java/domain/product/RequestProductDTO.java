package com.romeu.crud_java.domain.product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public record RequestProductDTO(
    Integer id,
    @NotBlank
    String name, 
    @NotNull
    Integer price) {}

