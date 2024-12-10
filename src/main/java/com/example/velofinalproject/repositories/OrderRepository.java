package com.example.velofinalproject.repositories;

import com.example.velofinalproject.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
