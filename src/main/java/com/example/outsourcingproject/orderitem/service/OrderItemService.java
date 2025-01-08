package com.example.outsourcingproject.orderitem.service;

import com.example.outsourcingproject.OrderItemWrapper;
import com.example.outsourcingproject.orderitem.dto.request.CreateOrderItemRequestDto;
import java.util.List;

public interface OrderItemService {

  OrderItemWrapper createOrderItem(List<CreateOrderItemRequestDto> requestDtoList);
}