package com.example.outsourcingproject.orderitem.controller;

import com.example.outsourcingproject.OrderItemWrapper;
import com.example.outsourcingproject.orderitem.dto.request.CreateOrderItemRequestDto;
import com.example.outsourcingproject.orderitem.service.OrderItemServiceImpl;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

  private final OrderItemServiceImpl orderItemService;

  public OrderItemController(OrderItemServiceImpl orderItemService) {
    this.orderItemService = orderItemService;
  }

  @PostMapping
  public ResponseEntity<OrderItemWrapper> createOrderItem(
      @RequestBody List<CreateOrderItemRequestDto> requestDtoList
  ) {
    OrderItemWrapper responseDtoWrapper = orderItemService.createOrderItem(requestDtoList);

    return new ResponseEntity<>(responseDtoWrapper, HttpStatus.CREATED);
  }
}