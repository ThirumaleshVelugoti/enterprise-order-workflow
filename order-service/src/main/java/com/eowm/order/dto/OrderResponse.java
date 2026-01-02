package com.eowm.order.dto;

import com.eowm.order.model.OrderStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class OrderResponse {

    private Long id;
    private String orderNumber;
    private String createdBy;
    private OrderStatus status;
    private Double amount;
    private LocalDateTime createdAt;
}
