package com.example.velofinalproject.dtos.basket;

import com.example.velofinalproject.dtos.product.ProductBasketDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketDto {
    private Long id;
    private Float quantity;
    private Long productId;
    private ProductBasketDto product;
}
