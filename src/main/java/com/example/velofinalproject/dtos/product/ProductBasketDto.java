package com.example.velofinalproject.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBasketDto {
    private Long id;
    private String potoUrl;
    private String name;
    private Float price;
}
