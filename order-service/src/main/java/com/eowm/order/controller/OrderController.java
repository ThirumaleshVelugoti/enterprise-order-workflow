package com.eowm.order.controller;

import com.eowm.order.dto.CreateOrderRequest;
import com.eowm.order.dto.OrderResponse;
import com.eowm.order.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    public OrderResponse createOrder(@Valid @RequestBody CreateOrderRequest request,
                                     Authentication authentication) {
        return orderService.createOrder(request, authentication);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','USER')")
    public List<OrderResponse> getOrders(Authentication authentication) {

        boolean isAdminOrManager =
                authentication.getAuthorities().stream()
                        .anyMatch(a ->
                                a.getAuthority().equals("ROLE_ADMIN")
                                        || a.getAuthority().equals("ROLE_MANAGER")
                        );

        return orderService.getOrders(authentication, isAdminOrManager);
    }
}
