package com.app.globazaar.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductDto {
    private Long id;
    @NotEmpty
    @Size(min = 2,message = "Product name should have minimum 2 characters")
    private String name;
    @NotEmpty
    @Size(min = 3,message = "Category should have minimum 3 characters")
    private String category;
    @NotNull(message = "Price cannot be null")
    private Double price;
    @NotEmpty
    private String description;
}

