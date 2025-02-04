package com.example.velofinalproject.dtos.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private String phoneNumber;
    private String address;
    private String message;
    List<OrderItemDto> orderItems=new ArrayList<>();
}
