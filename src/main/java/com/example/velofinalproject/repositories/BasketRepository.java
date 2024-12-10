package com.example.velofinalproject.repositories;

import com.example.velofinalproject.models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    List<Basket> findByUserId(Long userId);

    Basket findByUserIdAndProductId(Long userId, Long productId);
}