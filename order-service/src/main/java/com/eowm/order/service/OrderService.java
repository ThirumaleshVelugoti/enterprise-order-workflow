package com.eowm.order.service;

import com.eowm.order.dto.CreateOrderRequest;
import com.eowm.order.dto.OrderResponse;
import com.eowm.order.model.Order;
import com.eowm.order.model.OrderStatus;
import com.eowm.order.repository.OrderRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponse createOrder(CreateOrderRequest request, Authentication auth) {

        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .amount(request.getAmount())
                .createdBy(auth.getName())
                .status(OrderStatus.CREATED)
                .build();

        Order saved = orderRepository.save(order);

        return mapToResponse(saved);
    }

    public List<OrderResponse> getOrders(Authentication auth, boolean isAdminOrManager) {

        List<Order> orders = isAdminOrManager
                ? orderRepository.findAll()
                : orderRepository.findByCreatedBy(auth.getName());

        return orders.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private OrderResponse mapToResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .orderNumber(order.getOrderNumber())
                .createdBy(order.getCreatedBy())
                .status(order.getStatus())
                .amount(order.getAmount())
                .createdAt(order.getCreatedAt())
                .build();
    }
}
