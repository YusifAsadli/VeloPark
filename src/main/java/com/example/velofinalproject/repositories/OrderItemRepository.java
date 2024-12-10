package com.example.velofinalproject.repositories;

import com.example.velofinalproject.models.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItems, Integer> {
    List<OrderItems> findByOrderId(Long orderId);
}
