package com.example.velofinalproject.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDto {
    private String name;
    private String description;
    private String potoUrl;
    private Double price;
    private Float quantity;
    private Long categoryId;

}
