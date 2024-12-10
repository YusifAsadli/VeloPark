package com.example.velofinalproject.dtos.product;

import com.example.velofinalproject.dtos.category.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductShopDto {
    private Long id;
    private String name;
    private Float price;
    private String potoUrl;
    private CategoryDto category;
}