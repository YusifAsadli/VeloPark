package com.example.velofinalproject.dtos.basket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketAddDto {
    private Float quantity;
    private Long productId;
}
