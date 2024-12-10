package com.example.velofinalproject.services.impls;

import com.example.velofinalproject.dtos.order.OrderDashboardDto;
import com.example.velofinalproject.dtos.order.OrderDetailDto;
import com.example.velofinalproject.dtos.order.OrderPlaceDto;
import com.example.velofinalproject.models.Basket;
import com.example.velofinalproject.models.Order;
import com.example.velofinalproject.models.OrderItems;
import com.example.velofinalproject.models.UserEntity;
import com.example.velofinalproject.repositories.BasketRepository;
import com.example.velofinalproject.repositories.OrderItemRepository;
import com.example.velofinalproject.repositories.OrderRepository;
import com.example.velofinalproject.repositories.UserRepository;
import com.example.velofinalproject.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceIplms implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final BasketRepository basketRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderServiceIplms(OrderRepository orderRepository, ModelMapper modelMapper, UserRepository userRepository, BasketRepository basketRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.basketRepository = basketRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public boolean placeOrder(OrderPlaceDto orderplaceDto, String userEmail) {
        UserEntity user = userRepository.findByEmail(userEmail);
        Order order = modelMapper.map(orderplaceDto, Order.class);
        List<Basket> findBasket = basketRepository.findByUserId(user.getId());
        for (Basket basket : findBasket) {
            OrderItems orderItems = new OrderItems();
            orderItems.setQuantity(basket.getQuantity());
            orderItems.setProduct(basket.getProduct());
        }
        order.setUser(user);
        orderRepository.save(order);
        return true;
    }

    @Override
    public List<OrderDashboardDto> getDashboardOrder() {
        List<Order> getOrders = orderRepository.findAll();
        List<OrderDashboardDto> orderDashboardDtos =getOrders.stream().map(order->modelMapper.map(order, OrderDashboardDto.class)).collect(Collectors.toUnmodifiableList());
        return orderDashboardDtos;
    }

    @Override
    public List<OrderDetailDto> getOrderById(Long id) {
        List<OrderItems> orderItems=orderItemRepository.findByOrderId(id);
        List<OrderDetailDto> orderDetailDto=orderItems.stream().map(item->modelMapper.map(item, OrderDetailDto.class)).collect(Collectors.toList());
        return orderDetailDto;
    }
}
