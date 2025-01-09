package com.example.outsourcingproject.order.dto.request;

import com.example.outsourcingproject.OrderStatus;
import lombok.Getter;

@Getter
public class UpdateOrderRequestDto {

    private final Long id;
    private final String orderStatus;

    public UpdateOrderRequestDto(
        Long id,
        String orderStatus
    ) {
        this.id = id;
        this.orderStatus = orderStatus;
    }
}