package com.example.velofinalproject.dtos.product;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String potoUrl;
    private Float quantity;
    private Long categoryId;
    

}
