package com.example.velofinalproject.services;

import com.example.velofinalproject.dtos.basket.BasketAddDto;
import com.example.velofinalproject.dtos.user.UserBasketDto;

public interface  BasketService {
    void addToCart(BasketAddDto basketAddDto, String userEmail);
    UserBasketDto getBasket(String email, String coupon);
    void removeBasketItem(String userEmail, Long id);
}