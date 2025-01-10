package com.example.outsourcingproject.order.dto.response;

import com.example.outsourcingproject.Order;
import com.example.outsourcingproject.OrderStatus;
import lombok.Getter;

@Getter
public class UpdateOrderResponseDto {

    private final OrderStatus updatedOrderStatus;

    public UpdateOrderResponseDto(
        OrderStatus updatedOrderStatus) {
        this.updatedOrderStatus = updatedOrderStatus;
    }
}