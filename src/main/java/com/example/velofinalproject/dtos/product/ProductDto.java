package com.example.velofinalproject.dtos.product;

import com.example.velofinalproject.dtos.category.CategoryDto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String potoUrl;
    private Float quantity;
    private CategoryDto category;
}
