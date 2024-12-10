package com.example.velofinalproject.controllers;

import com.example.velofinalproject.dtos.order.OrderDashboardDto;
import com.example.velofinalproject.dtos.order.OrderDetailDto;
import com.example.velofinalproject.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/admin/orders")
    public String order(Model model) {
        List<OrderDashboardDto> orders =orderService.getDashboardOrder();
        model.addAttribute("orders", orders);
        return"/dashboard/orders/index";
    }
    @GetMapping("/admin/orders/{id}")
    public String detail(Model model, @PathVariable Long id){
        List<OrderDetailDto> order = orderService.getOrderById(id);
        model.addAttribute("orders",order);
        return "/dashboard/orders/detail";
    }
}
