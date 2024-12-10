package com.example.velofinalproject.services;

import com.example.velofinalproject.dtos.order.OrderDashboardDto;
import com.example.velofinalproject.dtos.order.OrderDetailDto;
import com.example.velofinalproject.dtos.order.OrderPlaceDto;

import java.util.List;

public interface OrderService {
    boolean placeOrder(OrderPlaceDto orderplaceDto, String userEmail);
    List<OrderDashboardDto> getDashboardOrder();
    List<OrderDetailDto> getOrderById(Long id);
}
