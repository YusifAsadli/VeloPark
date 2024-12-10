package com.example.velofinalproject.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductHomeDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String potoUrl;
}
