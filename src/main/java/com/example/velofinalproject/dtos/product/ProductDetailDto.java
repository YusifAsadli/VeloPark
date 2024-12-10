package com.example.velofinalproject.dtos.product;

import com.example.velofinalproject.dtos.category.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDetailDto {
    private Long id;
    private String name;
    private Float price;
    private String description;
    private CategoryDto category;
}
